package com.akv.advance

import scala.collection.immutable.Queue

object EX024_05_LazyList_Vector_Queue_Range extends App{
  /*
  * Lazy List are not evaluated while creation but on access
  * Vector provide "effective constant time" access/update on list
  * Each node of vector contains 32 elements
  * 2^30 elements can be created in 5 level of nodes
  * updated operation on vector creates a new Vector
  * Vector uses :+ to add element instead of cons(::)
  * queue supports enqueue and dequeue operations
  * dequeue returns a tuple of element and remaining list
  * Range creates a sequence, will have start,end and optional step
  * to operator includes the end while until doesn't include end
   */

  // LazyList
  def fibonacciSeq(a:Int,b:Int):LazyList[Int] ={
    a #:: fibonacciSeq(b,a+b)
  }

  println(fibonacciSeq(1,1).take(10))          // List not computed

  println(fibonacciSeq(1,1).take(10).toList)   // List computed now

  //Vector
  val emptyVectorList = Vector()

  val aVectorList = emptyVectorList :+ 1 :+ 2 :+ 3

  println(aVectorList)

  println(aVectorList.updated(2,-4))

  // Queue
  val emptyQueue = Queue[Int]()
  val oneQueue = emptyQueue.enqueue(1)
  val listQueue = emptyQueue.enqueueAll(List(1,2,3))

  println(oneQueue +" "+listQueue)

  val (popped, remainingQueue) = listQueue.dequeue  // dequeue returns a tuple of element and remaining element

  println(popped)
  println(remainingQueue)

  // range
  val rangeDefault = 1.to(3) // it includes last element
  println(rangeDefault)
  println(rangeDefault.mkString(" "))

  val rangeStepped = 1.to(15,3)
  println(rangeStepped)
  println(rangeStepped.mkString(" "))

  // range
  val rangeDefault2 = 1.until(3) // it includes last element
  println(rangeDefault2)
  println(rangeDefault2.mkString(" "))

  val rangeStepped2 = 1.until(15,3)
  println(rangeStepped2)
  println(rangeStepped2.mkString(" "))






}
