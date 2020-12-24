package com.akv.advance

object EX021_03_Multiple_Implicit extends App{
  /*
  * prior to scala 2.7 multiple implicit will fail
  * but from 2.8, scala will try to find and use the more specific one
  * rules for specific -> 1. it should be subType and 2. it should extends the class
  * Use below to see the actual implicit use:
  * scalac -Xprint:typer <file_name>.scala
   */

  def printLength(seq: Seq[Int]) = println(seq.length)

  implicit def intToRange(i: Int) = 1 to i

  implicit def intToDigits(i:Int) = i.toString.toList.map(_.toInt)

  //printLength(12)  will not compile due to ambiguous implicit functions

}
