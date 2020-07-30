package com.akv.basic
import scala.io.Source

object  EX030_read_file extends App{

  val file_name ="./src/com/akv/basic/EX001_forLoop.scala"

  val lineList = Source.fromFile(file_name).getLines().toList

  for (line <- lineList) println(line.length+"| "+line)

  // get max width Line
  val maxWidthLine =lineList.reduceLeft((a,b) => if (a.length>= b.length) a else b)
  println(maxWidthLine)

  def lineWidth(line:String):Int = line.length.toString.length

  for (line <- lineList){
    val blankToFill = lineWidth(maxWidthLine) - lineWidth(line)
    val padding = " " * blankToFill
    println(padding+line.length + "|"+line)

  }


}
