package com.akv.udemy.basic.lectures.functionalProgramming

object EX019_Anonymous_functions extends App{

  // explicit declaration
  val doubler = new (Int=>Int){
    override def apply(v1: Int): Int = v1*2
  }

  // same as above, using anonymous/Lambda functions
  val doubler2 = (a:Int) => a*2
  println(s"doubler ${doubler(2)} doubler2 ${doubler2(3)}")

  // syntactic sugar

  val adder = (x:Int,y:Int) => x+y

  val adder2:(Int,Int)=> Int = _+_ // equivalent to (a+b)+> a+b

  println(s"Adder ${adder(2,4)} Adder2 ${adder2(3,5)}")

  // example f(int,func)
  val superAdd = (x:Int) => ((y:Int) => x+y)

  println(superAdd(3)(4))

}
