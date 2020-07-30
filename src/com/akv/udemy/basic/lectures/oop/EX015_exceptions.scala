package com.akv.udemy.basic.lectures.oop

object EX015_exceptions extends App {

  // 1. Throw a exception
  //  val a:String = null
  //  val b = a.length

  // 2. catch and handle exceptions
  def exceptionTest(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException
    else 42
  }

  val result = try {
    val a = exceptionTest(true)
  }
  catch {
    case e: RuntimeException => {
      println("exception caught"); 43
    }
  }
  finally {
    println("finally")
  }

  println(result)

  //3. Defining custom exception

      //  class MyException extends Exception
      //
      //  val myException = throw new MyException


}
