package com.akv.basic

object EX013_03_Access_Companion extends App{

  // Companion Objects can access each others private members

  class A {
    private def f() = println(A.a)
  }

  object A {
    private val a = 5
    def Apply: Unit ={
      val a = new A
      println("Inside apply")
      a.f()
    }
  }

  val a = A.Apply


}
