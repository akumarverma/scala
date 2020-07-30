package com.akv.udemy.basic.lectures.basic

object EX002_Expressions extends App{

  val aSum = 1+2

  var aVal=0
  aVal+= 5

  val anIfExpression = if (aVal> 0) "positive" else "negative"

  val aCodeBlock = {
    if (aVal> 0) "positive" else "negative"
    println("hello")
    5

  }

  println(s"$aSum $aVal $anIfExpression $aCodeBlock")

}
