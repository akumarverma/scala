package com.akv.basic

object EX010_01_inheritance extends App{
  /*
  * Members with no definition are abstract members, abstract keyword is not required for methods
  * but required for classes having abstract methods.
  * we should be defining empty-paran methods for methods having side effects whereas parameterless
  * methods if it just access some properties.
   */

  // Ex 1
  class A {
    def aDef: Unit = println("in aDef")         // parameterless methods
    def aDef2(): Unit = println("in aDef2()")   // empty-paren methods

  }

  val a = new A
  println(s" ${a.aDef} ${a.aDef2()}")

  // Note : a def with no parameter can be defined with () or without ()

  // Ex 2: use of val vs def
  class B(aArray: Array[String]) {
    def lengthOfArrayDef = aArray.length
    var lengthOfArrayVar = aArray.length
  }

  val b = new B(Array("Amit","Shubh","Prisha","Swati"))
  println(b.lengthOfArrayVar+" "+ b.lengthOfArrayDef)

  // Note : a parameter less def can also be written as variable
  // variable takes memory whereas def will be evaluates each time when invoked

  // Ex 3: Invoking super class constructor

  class Parent(val x:Int)
  class Child(override val x:Int) extends Parent(x)  // Invoking super class constructor

  val child:Parent = new Child(18) // child can be of Type parent

  // Ex 4 : Class extension
  class Cat {
    val dangerous = false
  }

  val cat = new Cat

  println(s"is Cat dangerous: ${cat.dangerous}")

  // Approach 1
  class Tiger(override val dangerous: Boolean,val age:Int) extends Cat
  // dangerous is overridden here

  val tiger = new Tiger(true,5)
  println(s"Tiger Properties: ${tiger.dangerous} ${tiger.age}")

  // Approach 2
  class Tiger2(val a: Boolean,val b:Int) extends Cat{
    override val dangerous: Boolean = a
    val age:Int = b
  }

  val tiger2 = new Tiger2(true,5)
  println(s"tiger2 Properties: ${tiger2.dangerous} ${tiger2.age}")

  // Note : override is required of overriding parent concrete method, for abstract method it is optional
  // it is not allowed for non-parent class methods
}
