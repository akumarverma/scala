package com.akv.basic

object EX014_1_Polymorphism extends App{

  // Ex 1
  class A {
    def demo() = println("inside A")
  }

  class AA extends A{
    override def demo() = println("inside AA")
  }

  class AAA extends AA{
    override final def demo() = println("inside AAA")  // Final method can not be overridden by child class
  }

  class AAAA extends AAA

  class AB extends A

  def demo(a: A) = a.demo()

  demo(new A)
  demo(new AA)
  demo(new AAA)
  demo(new AB)    // Invokes parent's demo method since demo is not overridden

  // Ex 2
  final class B {
    def demo() = println("this is final class not cannot ve subclassed")
  }

  //class BB extends B // Not valid, can't subclass B as it is final

}
