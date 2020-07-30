package com.akv.basic

object EX013_1_Function_literals_shorthand extends App {

  val aList = List(1,2,3,4)

  println(aList.map((x:Int) => x+1))
  println(aList.map((x) => x+1))
  println(aList.map(x => x+1))
  println(aList.map( _+1))    // -+1 is equivalent to x => x+1

  val f = (_:Int) + (_:Int) // accept 2 parameters, not a repeated one
  println(f(1,2))


}
