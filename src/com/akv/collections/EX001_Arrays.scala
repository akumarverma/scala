package com.akv.collections

object  EX001_Arrays extends App {

  val intArray = new Array[Int](5) // values are initialised to zero
  for(i <- intArray) println(i)

  val stringArray = new Array[String](5) // values are initialised to null
  for(i <- stringArray) println(i)

  val intArray2 = Array(1,2,46,7,8) // creation and initialization of Array
  for(i <- intArray2) println(i)

  intArray(2) = intArray2(2)        // value access and assignment
  for(i <- intArray) println(i)
}
