package com.akv.udemy.basic.lectures.oop

import scala.collection.View.Empty

object EX011_MyList extends App{

  // implements head, tail, isEmpty, toString

  abstract class MyList[+A]{
    def head(): A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B>:A](num:B): MyList[B]
    def printElements:String
    override def toString: String = "MyList["+ printElements +"]"

    def map[B](transformer: MyTransformer[A,B]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    //def flatMap[B](transformer: MyTransformer[A,List[B]]): MyList[B]
  }

  object Empty extends MyList[Nothing]{
    def head: Nothing = throw new NoSuchElementException
    def tail: Nothing = throw new NoSuchElementException
    def isEmpty: Boolean = true
    override def printElements: String = ""
    def add[B>: Nothing](element:B): MyList[B] = new Cons(element,Empty)

    def map[B](transformer: MyTransformer[Nothing,B]): MyList[B]= Empty
    def filter(transformer: MyPredicate[Nothing]): MyList[Nothing]= Empty
   // def flatMap[B](transformer: MyTransformer[Nothing,List[B]]): MyList[B]= Empty
  }

  class Cons[+A](h:A,t: MyList[A]) extends MyList[A]{
    def head():A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def printElements: String = {
      if (t.isEmpty) "" + h
      else {
        // println("value of h is"+h);
        h+" "+ t.printElements
      }

    }
    def add[B>:A](num:B): MyList[B] = new Cons(num,this)

    def map[B](transformer: MyTransformer[A,B]): MyList[B] ={
      new Cons(transformer.transform(h),t.map(transformer))
    }
    def filter(predicate: MyPredicate[A]): MyList[A] ={
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else{
        t.filter(predicate)
      }
    }
   // def flatMap[B](transformer: MyTransformer[A,List[B]]): MyList[B] ={}
  }

  trait MyPredicate[-A]{
    def test[A](h:A): Boolean
  }

  trait MyTransformer[-A,B]{
    def transform(element:A): B
  }


  val one = new Cons(1,Empty)
  val oneAndTwo = one.add(2)
  println(one)
  println(oneAndTwo)
  val aLongList = new Cons(1,new Cons(2,new Cons(3, Empty)))

  println(aLongList)

  val oneString = new Cons("One",Empty)
  val oneAndTwoString = oneString.add("Two")
  println(oneString)
  println(oneAndTwoString)
  val aLongStringList = new Cons("One",new Cons("Two",new Cons("Three", Empty)))

  println(aLongStringList)


}
