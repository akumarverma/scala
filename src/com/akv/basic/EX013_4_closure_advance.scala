package com.akv.basic

object EX013_4_closure_advance extends App {

  // a function returning a function
  def inc(x:Int) = (y:Int) => x+y

  println(inc(5))  // returns a function, 5 is bound to function

  val inc_fun = inc(5) // same as above line

  println(inc_fun)  // return a function

  println(inc_fun(4)) // return the value of function inc_fun

  println(inc(5)(4)) // equivalent to the above

}
