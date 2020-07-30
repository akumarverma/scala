package com.akv.udemy.advance.patternMatching

object EX002_Partial_functions extends App{

  def func(x:Int):Int = x+1  // regular function, domain of x is Int

  val partialFunc: PartialFunction[Int,String] = { // domain is 1,2,3
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
  }

   println(partialFunc(2))

  partialFunc.isDefinedAt(34)   // check the existence of number in domain

  val lifted = partialFunc.lift // turn value in Option(some/None)
  println(lifted(2))


}
