package com.akv.basic

object EX008_01_Function_Literals extends App{
  /*
  * function literals x=> x+1, compiler translate it to an class
  * since it is an class, we can assign it to a variable like val x= (x:Int)=> x+1
  * if used in conjunction with collections, parameter type will in inferred, hence not needed(target Typing)
  * parameters can be _ like list.filter(_>0) is equivalent to list.filter(x=> x>0)
  * Multiple underscore means multiple parameters
  */

  // function names
  val increment =(x:Int) =>{
    x+1
  }

  val value1= increment(10)
  val value2 = increment(20)

  println(s"values of value1 and value2 are: $value1 $value2")

  val aList = List(1,2,3,4,5)
  aList.foreach(x => print(increment(x)))
  println()


  // Note: function literals are compiled as class at runtime like below

  class anonClass(val x: Int)

  object anonClass{
    def apply(x:Int):Int=>Int= x=> x+1
  }

  val x = anonClass(10)
  println(x)
  println(x(1))


}
