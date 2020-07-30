package com.akv.basic

object EX013_2_partial_Applied_functions extends App{

  def sum(a:Int, b:Int,c:Int):Int = a+b+c

  // Ex. 1 with no parameter
  val aPartialFunction = sum _  // a partial Applied function

  println(aPartialFunction(1,2,3))

  // a partial function is created as object as shown below
  object aPartialAppliedFunction {
    def apply(a:Int,b:Int,c:Int) = sum(a,b,c)
  }

  println(aPartialAppliedFunction(3,4,5))

  // Ex. 2 with 2 parameters
  val aPartialFunctionWithParam = sum(0,_,1)
  println(aPartialFunctionWithParam(3))

  // scala write aPartialFunctionWithParam as below
  object aPartialFunctionWithParamObject {
    def apply(x:Int) = sum(0,x,1)
  }
  println(aPartialFunctionWithParamObject(4))



}
