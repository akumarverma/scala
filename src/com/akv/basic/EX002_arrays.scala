package com.akv.basic

object EX002_arrays extends App{

  // Array declaration and separate initialization
  val aArray = new Array[Int](3)

  //Option 1
  aArray(0)=0
  aArray(1)=1
  aArray(2)=2

  for (i<- 0 to 2)
    print(aArray(i))

  println()

  //Option 2
  aArray.update(0,3)
  aArray.update(1,4)
  aArray.update(2,5)

  for (i<- 0 to 2)
    print(aArray.apply(i))

  println()

  // Array declaration and initialization in one step(Option 1)
  val aStringArray = Array("one","two","three")

  aStringArray.foreach(print)

  println()

  // Array declaration and initialization in one step( option 2)
  val aStringArray2 = Array.apply("ONE","TWO","THREE")

  aStringArray2.foreach(print)

  println()

}
