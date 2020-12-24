package com.akv.basic

import scala.collection.mutable.ArrayBuffer

object EX012_03_Stackable_Modifications extends App{

  // abstract class with get and put method
  abstract class IntQueue{
    def get(): Int
    def put(x:Int): Unit
  }
  // concrete class implementing get and put method
  class BasicIntQueue extends IntQueue {
    private val buffer = ArrayBuffer[Int]()
    override def get(): Int = buffer.remove(0)

    override def put(x: Int): Unit = buffer += x

    override def toString: String = buffer.mkString("[",",","]")

  }

  // inserting and removing data from queue
  val basicIntQueue = new BasicIntQueue
  basicIntQueue.put(1)
  basicIntQueue.put(5)
  basicIntQueue.put(7)
  basicIntQueue.put(-4)
  println(basicIntQueue)
  println(basicIntQueue.get())
  println(basicIntQueue.get())
  println(basicIntQueue)

  // stack modification to double the inserted value
  trait Doubling extends IntQueue{
    // this trait can be mixed in only by the class implementing IntQueue

    abstract override def put(x: Int): Unit = super.put(x*2)
    // Note: This will work only in trait if class mixing it provide a concrete implementation
  }

  // creating a class with code but to extends the BasicIntQueue with doubling
  class myDoubleIntQueue extends BasicIntQueue with Doubling

  val myDoubleIntQueue = new myDoubleIntQueue
  myDoubleIntQueue.put(1)
  myDoubleIntQueue.put(5)
  myDoubleIntQueue.put(7)
  myDoubleIntQueue.put(-4)
  println(myDoubleIntQueue)
  println(myDoubleIntQueue.get())
  println(myDoubleIntQueue.get())
  println(myDoubleIntQueue)

  // similar as above, but to increment and filter the basic queue
  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = super.put(x+1)
  }

  trait Filtering extends  IntQueue {
    abstract override def put(x: Int): Unit = if (x>0) super.put(x)
  }

  class IncFilteredIntQueue extends BasicIntQueue with Incrementing with Filtering

  // Note: Order of mixin is important, it starts invoking right to left
  // A class is always linearized in front of this superclass and traits

  val incFilteredIntQueue = new IncFilteredIntQueue

  incFilteredIntQueue.put(1)
  incFilteredIntQueue.put(5)
  incFilteredIntQueue.put(7)
  incFilteredIntQueue.put(-4)
  println(incFilteredIntQueue)
  println(incFilteredIntQueue.get())
  println(incFilteredIntQueue.get())
  println(incFilteredIntQueue)





}
