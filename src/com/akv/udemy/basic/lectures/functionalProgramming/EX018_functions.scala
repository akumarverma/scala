package com.akv.udemy.basic.lectures.functionalProgramming

object EX018_functions extends App{

  // 1. use your own objects and override
  trait MyFunction[A,B]{
    def apply(element:A):B
  }

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element*2
  }

  println(doubler(3))

  //2. use Scala provided functions

  val doubler2 = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1*2
  }
  println(doubler(4))

  //3. Example 3 with 2 input and result

  val adder:Function2[Int,Int,Int] = new Function2[Int,Int,Int] {
    override def apply(v1: Int, v2: Int): Int = v1+v2}

  println(adder(4,5))

  //3. Example 3 with syntactic sugar

  val adder2:((Int,Int)=>Int) = new ((Int, Int) => Int) {
    override def apply(v1: Int, v2: Int): Int = v1+v2}

  println(adder(4,5))

  // Note: All scala functions are objects

  // Example 4: concatenation of two String
  val concat:((String,String)=> String) = new ((String,String)=> String){
    override def apply(v1: String, v2: String): String = v1+v2
  }

  println(concat("hello","Amit"))

  // Example 5: Returning a function as result
  val superFunction = new ((Int) => ((Int) => Int)) {
    override def apply(a:Int):(Int) => Int = new ((Int)=>Int) {
      override def apply(b: Int): Int = a+b
    }
  }

  println(superFunction(3)(4))

}
