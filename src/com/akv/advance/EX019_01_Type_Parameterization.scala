package com.akv.advance

object EX019_01_Type_Parameterization extends App{

  /*
  * Type parametrization allows writing generic classes and traits
  * Sets is generic Set[Int], Set[String] etc
   */

  // Functional queue

  case class SlowAppendQueue[T](elems: List[T]) {
    def head = elems.head
    def tail = elems.tail
    def enqueue(elem:T) = elems ++ List(elem) // enqueue operation need traversal
  }

  case class slowHeaderQueue[T](reversedElems:List[T]) {

    def head = reversedElems.last    // slow require traversal
    def tail = reversedElems.init.reverse  //slow require traversal
    def enqueue(elem:T) = new slowHeaderQueue[T](elem :: reversedElems)  // append in fast

  }

  // Combining both approach will result in fast operation for all three
   class MyQueue[T](val leading:List[T],val trailing:List[T]){

    def head = mirror.leading.head


    def tail = mirror.leading.tail ::: mirror.trailing.reverse


    private def mirror ={
      if (leading.isEmpty) new MyQueue(trailing.reverse,Nil)
      else this
    }

    def enqueue(elem:T):MyQueue[T] = {
      new MyQueue[T](leading,elem:: trailing)
    }

    override def toString: String = "Leading: "+ leading.mkString(",") +" Trailing: " +
    trailing.mkString(",") +" Queue: " +
      (leading ::: trailing.reverse).mkString(",")
  }

  println(new MyQueue[Int](List[Int](),List[Int](3,2,1)).enqueue(4))
  println(new MyQueue[Int](List[Int](),List[Int](4,3,2,1)).enqueue(5))

  val q1 = new MyQueue[Int](List[Int](),List[Int]())
  println("q1: "+ q1)
  val q2 = q1.enqueue(1)
  println("q2: "+q2)
  val q3 = q2.enqueue(2)
  println("q3: "+q3)
  val q4 = q3.enqueue(3)
  println("q4: "+q4)
  println(s"${q4.head} ${q4.tail} ${q4.leading} ${q4.trailing}")








}
