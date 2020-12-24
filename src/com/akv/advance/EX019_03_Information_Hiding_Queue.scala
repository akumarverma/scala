package com.akv.advance

import com.akv.advance.EX019_01_Type_Parameterization.MyQueue

object EX019_03_Information_Hiding_Queue extends App {
  /*
  * the queue implementation class is completely hidden, trait is exposed publicly
  * trait MyQueue is not a type since it take a parameter
  * MyQueue[Int], myQueue[String] are types
   */
  trait MyQueue[T]{
    def head:T
    def tail: MyQueue[T]
    def enqueue(elem:T):MyQueue[T]
  }

  object MyQueue {

    def apply[T](xs:List[T]) = new MyQueueImpl[T](Nil,xs.reverse)

    class MyQueueImpl[T] (private val leading:List[T],private val trailing:List[T]) extends MyQueue[T] {

      def head = mirror.leading.head


      def tail:MyQueue[T] = new MyQueueImpl[T](mirror.leading.tail,mirror.trailing)


      private def mirror ={
        if (leading.isEmpty) new MyQueueImpl[T](trailing.reverse,Nil)
        else this
      }

      def enqueue(elem:T):MyQueue[T] = {
        new MyQueueImpl[T](leading,elem:: trailing)
      }

      override def toString: String = "Leading: "+ leading.mkString(",") +" Trailing: " +
        trailing.mkString(",") +" Queue: " +
        (leading ::: trailing.reverse).mkString(",")

    }
  }

  val q1 = MyQueue[Int](List[Int]())
  println("q1: "+ q1)
  val q2 = q1.enqueue(1)
  println("q2: "+q2)
  val q3 = q2.enqueue(2)
  println("q3: "+q3)
  val q4 = q3.enqueue(3)
  println("q4: "+q4)
  println(s"${q4.head} ")
  println(s"${q4.tail} ")

}
