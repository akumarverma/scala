package com.akv.collections

import scala.collection.mutable.ListBuffer

object EX002_ListBuffer extends App{

  /*
  * List allows fast access towards the head of List but not at the end
  * List is immutable.
  * ListBuffer is mutable, it allows constant time for prepend(+=: and append(+=)
   */

  val listBuffer = new ListBuffer[Int]

  listBuffer += 1
  listBuffer += 2            // Appending

  println(listBuffer)

  -1+=: listBuffer           // Prepending
  println(listBuffer)

  println(listBuffer.toList) // converting it to List



}
