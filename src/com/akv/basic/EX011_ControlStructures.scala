package com.akv.basic
import java.io.File
import scala.io.Source

object EX011_ControlStructures extends App{

  // if expression
  val aList = List()
  val anotherList = if (aList.isEmpty) List(0) else List(1)
  println(anotherList)

  // while loop to create greatest common denominator
  def gcd(x:Int, y:Int): Int ={
    var a=x
    var b =y
    while (a!=0){
      println(s"value of a and b are $a $b")
      val temp = a
      a = a % b
      println(s"new value for a is $a")
      b = temp
    }
    b
  }

  // alternate to while loop using recursion
  def gcd2(x:Int, y:Int): Int ={
    if (x==0)  y else gcd2(x % y,x)
  }


  val result = gcd2(49,21)

  println(result)


  // file listing
  val filesHere = (new java.io.File("./src/com/akv/basic")).listFiles
  for (file <- filesHere if file.getName.startsWith("EX")) println(file)

  def getLines(file: File): Array[String]={
    scala.io.Source.fromFile(file).getLines().toArray
  }

  //nested iteration
  for (file <- filesHere
       if file.isFile
       if file.getName.endsWith(".scala");
       line <- getLines(file)
       if line.length() >30
       ) println(line)

  //yield to create another list
  val yieldList = for (file <- filesHere
       if file.isFile
       if file.getName.endsWith(".scala")
       ) yield file

  println(yieldList)
  for (f <-yieldList) println(f)

  //nested loop to yield
  val yieldMap = for (file <- filesHere
                       if file.isFile
                       if file.getName.endsWith(".scala");
                       line <- getLines(file)
                       ) yield Map(line-> line.length)

  println(yieldMap)
  for (map <- yieldMap) println(map)

}
