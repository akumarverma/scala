package com.akv.basic

object EX013_02_Access_Modifiers extends App{

  /*
  * Anything not qualified is public
  * private: Accessed inside class or nested class inside class
  * _root_ refers as parent of top level package
   */

  //private, Protected

  class A {
    private def f = println("private f in a")
    class B {
      private def g = println("private g in B") // g is not accessible in A, but allowed in Java
      f  // F is accessible since B is nested in A
    }
    val b = new B
  }

  val a = new A

  // Protected: Accessible only from subClass but not from package( Unlike Java)
  class Super {
    protected def f() = println("Protected in Super class")
  }

  class Sub extends Super{
    f()
  }

  val sub = new Sub()

}
// Scope of Access protection
package layer1{
  private[layer1] class A{ // visibility of A is inside com.akv.basic.layer1 and not beyond

  }
  package layer2 {
    object lay2{
      private[layer2] val a = new A() // A is accessible here
    }
  }
}
