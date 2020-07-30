package com.akv.udemy.basic.lectures.functionalProgramming

object EX020_HOF_Curries extends App{

  def nTimes(f: Int=> Int,n: Int,x:Int):Int ={
    if (n<=0) x
    else {
      println(s"value of n and x is: $n $x")
      nTimes(f,n-1,f(x))
    }
  }

  val plusOne:(Int => Int)= (x:Int) => x+1

  println(nTimes(plusOne,10,1))

  def nTimesBetter(f:Int => Int,n:Int):(Int=> Int)={
  if (n<=0) (x:Int)=> {println(x);x}
  else (x:Int) => {println(s"value of n and x is: $n $x");nTimesBetter(f,n-1)(f(x))}
  }

  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(5))

  //curried function
  def superAdder: Int => Int => Int = (x:Int) => (y:Int) => x+y
  val add = superAdder(10)(5)
  println(add)

  def superAdder2: Int => (Int => Int) = (x:Int) => ((y:Int) => x+y)
  val addStep1 = superAdder2(5)
  println(addStep1(2))

}