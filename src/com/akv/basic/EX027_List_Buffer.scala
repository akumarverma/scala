package com.akv.basic
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object EX027_List_Buffer extends App{

  // ListBuffer
  val listBuffer = ListBuffer[Int]()

  listBuffer+=1 //prepend
  listBuffer+=2
  0 +=: listBuffer // Append
  println(listBuffer)
  println(listBuffer.toList)

  // ArrayBuffer
  val arrayBuffer = ArrayBuffer[Int]()

  arrayBuffer+=1
  arrayBuffer+=2
  3 +=: arrayBuffer
  println(arrayBuffer)
  println(arrayBuffer.toArray)
  for(el <- arrayBuffer) print(el)
  arrayBuffer.foreach(print)


}
