package com.akv.basic
import scala.io.Source

// example to read a file and return a line having width>30
object EX008_07_File_Read_Local_functions extends App{

  // Approach 1: invoking a private function
  def processFile(fileName:String, width: Int){

    val file = Source.fromFile(fileName)

    for (line<- file.getLines())
      processLine(fileName,width,line)

  }

  private def processLine(fileName: String,width: Int,line: String): Unit ={

    if (line.length > width){
      println(s"$fileName : ${line.trim}")
    }
  }

  processFile("./src/com/akv/basic/EX010_FractionClass.scala",30)

  println("\n\n\nApproach 2")
  // Approach 2: invoking a nested function
  def processFile2(fileName:String, width: Int){
    // Local nested function
    def processLine2(fileName: String,width: Int,line: String): Unit ={

      if (line.length > width){
        println(s"$fileName : ${line.trim}")
      }
    }

    val file = Source.fromFile(fileName)

    for (line<- file.getLines())
      processLine2(fileName,width,line)

  }

  processFile2("./src/com/akv/basic/EX010_FractionClass.scala",30)

  println("\n\n\nApproach 3")
  // Approach 3: invoking a nested function and using parameter of parent function
  def processFile3(fileName:String, width: Int){

    // Local nested function, fileName and width parameter of parent function is visible here
    def processLine3(line: String): Unit ={

      if (line.length > width){
        println(s"$fileName : ${line.trim}")
      }
    }

    val file = Source.fromFile(fileName)

    for (line<- file.getLines())
      processLine3(line)

  }

  processFile3("./src/com/akv/basic/EX010_FractionClass.scala",30)

}
