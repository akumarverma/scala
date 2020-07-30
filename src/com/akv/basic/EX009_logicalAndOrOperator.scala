package com.akv.basic

object EX009_logicalAndOrOperator extends App{

  def aTrue: Boolean = {
    println("this is a true value")
    true
  }

  def aFalse: Boolean = {
    println("this is a false value")
    true
  }

  val result1 = aFalse && aTrue // aTrue will not be evaluated

  println(s"values of result1 is $result1 ")

  val result2 = aTrue || aFalse // aFalse will not be evaluated

  println(s"values of result2 is $result2")

  val result3 = aTrue && aFalse // both will  be evaluated

  println(s"values of result3 is $result3 ")

  val result4 = aTrue && aFalse // both will  be evaluated

  println(s"values of result4 is  $result4")

}
