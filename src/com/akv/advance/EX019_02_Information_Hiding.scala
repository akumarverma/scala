package com.akv.advance

object EX019_02_Information_Hiding extends App{

  class A private(val a:Int)

  // private constructor instance can not ve created
  // it can be accessed by companion object
  /*
  val a = new A(1)
  Error:(7, 11) constructor A in class A cannot be accessed in object
  EX001_02_Information_Hiding from object EX001_02_Information_Hiding in package advance
  val a = new A(1)
  */

  object A {
    def apply(a:Int) = new A(a)
  }

  val x = A(5)
  println(x.a)

}
