package com.akv.basic

import com.akv.basic.EX015_02_Case_Class_Expr_Example.Number
import com.akv.basic.EX015_02_Case_Class_Expr_Example.{BinOP, Expr}

object EX015_04_Pattern_everywhere extends App{

  // Patterns in tuple

  val aTuple = Tuple3(1,true,"Amit")
  val (a,b,c) = aTuple
  println(s" $a $b $c")

  // destructing case class
  val binOp = new BinOP("*", Number(5),Number(2))
  val BinOP(op,expr1,expr2) = binOp
  println(s" $op $expr1 $expr2")

  // case sequence as function literals
  // instead of having single entry point with parameters, case sequence provide multiple entry points
  // in below eg, function literal is of form Option[Int]=> Int


  val withDefault:Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  println(withDefault(Some(5)))
  println(withDefault(None))

  // sequence of case gives partial functions
  val second:List[Int] => Int = {
    case x:: y:: _ =>y
}
  println(second(List(1,2,3)))
  // println(second(List()))     // throws MatchError

  // same example written with PartialFunctions
  val second2:PartialFunction[List[Int],Int] = {
    case x:: y:: _ =>y
  }

  // Note : partial functions has isDefinedAt method

  println(second2.isDefinedAt(List(1,2,3)))  // true
  println(second2.isDefinedAt(List()))       // false

  // for loop pattern matching
  val capitals = Map("Finland"->"Helsinki","India"->"New Delhi","Sweden"->"Stockholm")

  for ((country,capital) <- capitals) println(s"The capitial of $country is $capital")

  val aList = List(Some(5),None, Some(4))

  for (Some(x) <- aList) println(x)   // None is escaped since it doesn't match the pattern

}
