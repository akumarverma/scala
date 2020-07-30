package com.akv.basic

import java.io.{File, FileNotFoundException, FileReader, IOException}
import java.net.{MalformedURLException, URL}

object EX011_1_Exception_handling extends App {

  // function that can raise exceptions
  def half(n: Int) = {

    if (n%2==0) n/2
    else throw new RuntimeException("n Should be a even number")

  }

  // handling errors
  try{
    println(half(4))
    println(half(5))
  }
  catch {
    case e: RuntimeException => println("A runtime error occurred: "+e)
  }
  finally{
    println("finally reached here...")
  }

  // ex: 2 file handling
  try{
    val file: FileReader = new FileReader("./a.txt")
    println(file)
  }
  catch{
    case e: FileNotFoundException => println("no file found ")
    case e: IOException => println("unable to read file")
  }
  finally{
    println("reached here finally")
  }

  // ex 3: URL Matching
  def myURL(url:String): URL ={
    try{
      new URL(url)
    }
    catch {
      case e: MalformedURLException => new URL("https://akv.com")
    }
  }

  println(myURL("https://google.com"))
  println(myURL("Not a URL"))

  // ex 4: return type of try catch
  def f:Int = try 1 finally 3
  println(f) // finally clause value is ignored, only value returned by try and catch is taken into account

  def g:Int = try return 1 finally return 3
  println(g) // "Return" changes the default scala behaviour

}
