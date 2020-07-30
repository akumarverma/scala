package com.akv.basic

import java.io.{File, PrintWriter}

object EX013_8_Curried_Function_contd extends App{

  println("hello world")
  println{"hello world"} // Scala allows using {} while invoking single parameter functions

  def printWithFileWriter(file: File)(op: PrintWriter=> Unit) ={
    val writer = new PrintWriter(file)
    try{
      op(writer)  // "Loan Pattern", loaning it to op method
    }
    finally {
      writer.close()
      println("file written and closed")
    }
  }

  printWithFileWriter(new java.io.File("data.txt")){
    writer => writer.println(new java.util.Date())
  }


}
