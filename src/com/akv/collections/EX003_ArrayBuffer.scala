package com.akv.collections

import scala.collection.mutable.ArrayBuffer

object EX003_ArrayBuffer extends App{

  val intBuffer = new ArrayBuffer[Int]()

  intBuffer+=4  //append
  intBuffer+=2
  println(intBuffer)
  println(intBuffer.length)
  -5+=:1+=:intBuffer  //prepend
  println(intBuffer)
  intBuffer.remove(1)
  println(intBuffer)

}
