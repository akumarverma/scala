package com.akv.advance

object EX024_07_Mutable_Concrete_Classes extends App{
  /*
  * ArrayBugger, ListBuffer, Queue, Stack, StringBuilder
  * instead of enqueue use += to enqueue in mutable queue
  * dequeue return popped values not a tuple of (element,remaining queue) as of immutable queue
   */

  // ArrayBuffer
  val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]

  arrayBuffer += 1
  arrayBuffer ++= List(2,3,4)
  println(arrayBuffer)
  println(arrayBuffer(2))
  val aArray = arrayBuffer.toArray
  aArray.foreach(a => print(a))

  // ListBuffer
  val listBuffer = scala.collection.mutable.ListBuffer.empty[Int]

  listBuffer += 1
  listBuffer ++= List(2,3,4)
  println(listBuffer)
  println(listBuffer(2))
  val aList = arrayBuffer.toList
  println(aList)

  // queue
  val queue = scala.collection.mutable.Queue.empty[Int]

  queue += 1
  queue += 2
  queue ++= List(3,4,5)
  println(queue)
  val x = queue.dequeue()
  println(x)
  println(queue)

  // stack
  val stack = scala.collection.mutable.Stack.empty[Int]

  stack.push(1)
  stack.push(2)
  stack.pushAll(List(3,4,5))

  println(stack)

  println(stack.top)
  println(stack.pop())

  //StringBuilder
  val sBuilder = new StringBuilder

  sBuilder ++= "Amit"

  println(sBuilder)



}
