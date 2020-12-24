package com.akv.basic

object EX015_02_Pattern_guard_Overlaps extends App {

  // Pattern guard comes after pattern and starts with if
  def aMatch(any:Any) = any match {
    case x:String if (x.charAt(0)=='a') => "word start with a"
    case y:Int if (y>0) => "Number is greater than 0"
    case _ =>
  }

  println(aMatch("amit"))
  println(aMatch(5))
  println(aMatch(List(1,2,3)))


  def badMatch(expr:Any) = expr match {
    case _ => "Should not be first"          // it will overlap the more specific cases
    case x:Int => 1
  }

  println(badMatch(1))

}
