package com.akv.basic

object EX012_05_Self_in_Traits extends App()  {

  class A {
    def sayBye:Int = {println("Bye")
    1}
  }

  trait T { self: A=>
    val x = new A
    x.sayBye
    def sayHi:Int = {println("hi"); 1}

  }

  var b = new A with T

  println(b.sayHi)

}