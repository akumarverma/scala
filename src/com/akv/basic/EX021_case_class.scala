package com.akv.basic

object EX021_case_class extends App{

  // case class
  case class c1(field1:Int)
  // creating instance without new
  val x = c1(5)
  // accessing fields since constructor parameters are val
  println(x.field1)
  // Can copy a instance and optionally change field values
  val y = x.copy(7)
  println(y.field1)

  // check equality operator
  val z = x.copy()

  println(x==z)
  println(x==y)



}
