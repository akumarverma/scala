package com.akv.udemy.basic.lectures.functionalProgramming

import scala.util.Random

object EX022_Collections extends App {

  val aSeq = Seq(1,2,3,4)
  println(s"$aSeq ${aSeq.reverse} ${aSeq.head} ${aSeq.tail} ${aSeq.size} ${aSeq.isEmpty}")
  println(s"${aSeq.init} ${aSeq.last} ${aSeq.drop(2)} ${aSeq.take(2)} ${aSeq.mkString("[","-","]")}")

  println(-99+:aSeq)

  println(aSeq:+ -99)

  println(aSeq ++ Seq(5,6,7))

  // Range
  val uptoTen:Seq[Int] = 1 to 10
  uptoTen.foreach(println)

  // List
  val aList = List(1,2,3)
  val prePand = 3 +: aList
  println(prePand)

  val prePand2 = 3 :: aList
  println(prePand2)

  // Arrays
  val aIntArray: Array[Int] = new Array[Int](10)
  var i=0
  while( i < aIntArray.length){
    aIntArray(i) = i*i
    i+=1
  }
  print(aIntArray.mkString(" "))
  println()
  aIntArray(2) = -999
  print(aIntArray.mkString(" "))
  println()
  aIntArray.update(0,-1)
  print(aIntArray.mkString(" "))
  println()

  val arraySeq: Seq[Int] = aIntArray // Implict comversion from array to Seq
  println(arraySeq)

  val aArray = Array.ofDim[Int](5)
  aArray.foreach(print)
  println()

  // vectors
  val intVector = Vector(1,2,3)
  println(intVector)

  val maxRuns =1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double ={
    val random = new Random()
      val elapsedTimeSeq = for (it <- 1 to maxRuns)
        yield {
          val currentTime = System.nanoTime()
          collection.updated(random.nextInt(maxCapacity),random.nextInt())
          System.nanoTime() - currentTime
        }
    elapsedTimeSeq.sum/maxRuns
  }
  val seqList= (1 to maxCapacity).toList
  val vectorList = (1 to maxCapacity).toVector
  println(getWriteTime(seqList))
  println(getWriteTime(vectorList))
}
