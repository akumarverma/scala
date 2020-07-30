package com.akv.basic

import scala.collection.mutable

object EX006_Classes extends App {

  // verbose, explicit style
  class ChecksumAccumulator {
    private var sum = 0

    def add(x: Byte): Unit = {
      sum = sum + x
    }

    def checksum(): Int = {
      ~(sum & 0xFF) + 1
    }
  }

  val checkSumAcc = new ChecksumAccumulator
  println(checkSumAcc.add(10))
  println(checkSumAcc.checksum())

  // verbose, explicit style
  class ChecksumAccumulator2 {
    private var sum = 0

    def add(x: Byte): Unit = sum += x

    def checksum(): Int = ~(sum & 0xFF) + 1
  }

  val checkSumAcc2 = new ChecksumAccumulator
  println(checkSumAcc2.add(10))
  println(checkSumAcc2.checksum())

  object ChecksumAccumulator {

    private val cache = mutable.Map.empty[String, Int]

    def calculate(s: String): Int = {
      if (cache.contains(s))
        cache(s)
      else {
        val acc = new ChecksumAccumulator
        for (c <- s)
          acc.add(c.toByte)
        val cs = acc.checksum()
        cache += (s -> cs)
        cs
      }
    }
  }

    val aArray = Array("Amit","Swati","Shubh","Prisha")
    println(aArray)
    for (name <- aArray)
      println(s"$name: ${ChecksumAccumulator.calculate(name)}")


}
