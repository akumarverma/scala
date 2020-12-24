package com.akv.basic

import scala.collection.mutable

object EX004_01_Classes extends App {

  /*
  * Scala doesn't have static method but have singleton objects(starts with object)
  * if one file is having class and object with same name, it is called companion
  * singleton objects(also called first-class objects) are more than just defining static methods/fields
  * it can extends superclass and mix in traits
  * singleton object can't take parameters since it can't instantiate objects
  * A object not sharing name with companion class are called "standalone Objects"
  * such as object having main method
   */

  // verbose, explicit style
  class ChecksumAccumulator {
    private var sum = 0

    def add(x: Byte): Unit = { // method parameters are vals
      sum = sum + x
    }

    def checksum(): Int = {
      ~(sum & 0xFF) + 1
    }
  }

  val checkSumAcc = new ChecksumAccumulator
  println(checkSumAcc.add(10))
  println(checkSumAcc.checksum())

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

  val aArray = Array("Amit", "Swati", "Shubh", "Prisha")
  println(aArray)
  for (name <- aArray)
    println(s"$name: ${ChecksumAccumulator.calculate(name)}")

  // verbose, explicit style
  class ChecksumAccumulator2 {
    private var sum = 0

    def add(x: Byte): Unit = sum += x

    def checksum(): Int = ~(sum & 0xFF) + 1
  }

  object ChecksumAccumulator2 {

    private val cache = mutable.Map.empty[String, Int]

    def getChecksum(s: String): Int = {
      val checkSum = new ChecksumAccumulator2
      for (c <- s)
        checkSum.add(c.toByte)
      checkSum.checksum()
    }

    def calculate(s: String): Int = cache.getOrElseUpdate(s, getChecksum(s))


  }

  for (name <- aArray)
    println(s"$name: ${ChecksumAccumulator2.calculate(name)}")


}

/*
see the usage of getOrElseUpdate
The Map can be used as cache
//Option 1:
def calculate(s: String): Int = cache.getOrElseUpdate(s, getChecksum(s))

//Option 2:
    def calculate(s: String): Int = {
      if (cache.contains(s))
        cache(s)                             // get
      else {
        val acc = new ChecksumAccumulator
        for (c <- s)
          acc.add(c.toByte)
        val cs = acc.checksum()
        cache += (s -> cs)                  // or else update
        cs
      }
    }
 */
