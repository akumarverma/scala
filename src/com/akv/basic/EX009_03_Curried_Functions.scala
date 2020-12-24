package com.akv.basic

import java.io.{File, PrintWriter}

object EX009_03_Curried_Functions extends App{

  def normalSumFunction(x:Int,y:Int):Int = x+y

  println(normalSumFunction(1,2))

  def curriedSumFunction(x:Int)(y:Int) = x+y

  println(curriedSumFunction(1)(2))  // return sum, two function execute one by one

  println(curriedSumFunction(1)_)  // return a partial Function

  // the above is equivalent
  def first(x:Int):Int=>Int = (y:Int) => x+y

  def printWithFileWriter(file: File,op: PrintWriter=> Unit) ={
    val writer = new PrintWriter(file)
    try{
      op(writer)  // "Loan Pattern", loaning it to op method
    }
    finally {
      writer.close()
      println("file written and closed")
    }
  }

  printWithFileWriter(new java.io.File("data.txt"), writer => writer.println(new java.util.Date()))


}
