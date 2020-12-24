package com.akv.collections

object EX005_Tuples extends App{
  /*
  * Tuple hold data of different types
  * Can be used instead of creating needless classes
  * Since it can have multiple data types it doesn't inherit from iterable
  * Can be used returning multiple values from function
  *
   */

  val aTuple = Tuple3(1,"Amit",true)

  val (a,b,c) = aTuple
  println(s" $a $b $c")

  println(s" ${aTuple._1} ${aTuple._2} ${aTuple._3}")


}
