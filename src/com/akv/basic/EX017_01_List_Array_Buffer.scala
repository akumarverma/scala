package com.akv.basic
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object EX017_01_List_Array_Buffer extends App{
  /* list buffer vs List
  * 1. Lists are immutable whereas ListBuffer are mutable
  * 2. ListBuffer prepend and append takes same time whereas append in list is expensive
  * ListBuffer append operation (<list>:+x)
  * List buffer prepend operation (<List>+=x)
  *
  * ArrayBuffer
  * similar as array, items can be added at the start or end
  * items can be accessed by index
   */

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
