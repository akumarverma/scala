package com.akv.basic

object test extends App()  {

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