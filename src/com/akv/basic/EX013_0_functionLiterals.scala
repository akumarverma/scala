package com.akv.basic

object EX013_0_functionLiterals extends App{

  // function names
  val increment =(x:Int) =>{
    x+1
  }

  val value1= increment(10)
  val value2 = increment(20)

  println(s"values of value1 and value2 are: $value1 $value2")

  val aList = List(1,2,3,4,5)
  aList.foreach(x => println(increment(x)))


  // Note: function literals are compiled as objects at runtime like below
  object incrementObject{
    def apply(x:Int):Int = x+1
  }

  println(incrementObject(10))


}
