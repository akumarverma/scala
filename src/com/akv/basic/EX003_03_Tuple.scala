package com.akv.basic

object EX003_03_Tuple extends App{

  val aTuple = (1,"Amit",true)
  println(aTuple._1)
  println(aTuple._2)
  println(aTuple._3)

  /*
  * tuple doen't access list method as aTuple(0) since each element is of different type

   */

}
