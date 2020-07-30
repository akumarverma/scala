package com.akv.basic

import java.net.{MalformedURLException, URL}

object EX016_Exception extends App{

  // Example 1: raising a exception
  // comment/uncomment it for test other
//  val n=11
//  val half = {
//    if (n % 2 ==0)
//        n/2
//    else throw new RuntimeException
//  }

  // Example 2: try/catch/finally expression: throwing and catching a exception
  val tryCatchResult = try{
    val x=11
    val half2 = {
      if (x % 2 ==0)
        x/2
      else throw new RuntimeException
    }
  }
  catch{
    case runtimeException: RuntimeException =>
    println("a Odd value found")
      0
  }
  println(tryCatchResult)

  // Example 3: returning a URL
  val malformedUrl= "Not a URL"
  val url = try{
    new URL(malformedUrl)
  }
  catch{

    case ex:MalformedURLException => {
      println("URL provided is not a valid one so provding default")
      new URL("http://google.com")
    }
  }

  println(url)

  // example 4

  val a = try 0 finally 1
  println(a) // value of finally is not expression evaluation value

  def b():Int = try return 0 finally return 1
  println(b) // value of finally is not expression evaluation value

}
