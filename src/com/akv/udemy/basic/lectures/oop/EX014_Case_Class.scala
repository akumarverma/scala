package com.akv.udemy.basic.lectures.oop

object EX014_Case_Class extends App{

  case class Person(name:String,age:Int)
  // constructor parameters are fields
  // case class implement equals,toString, hashCode,copy operations by default
  // case class implement companion objects

  val amit = Person("Amit",42)
  println(amit)
  val anotherAmit = Person("Amit",42)
  println(amit== anotherAmit)
  println(amit.equals(anotherAmit))
  val sumit = amit.copy(age=35)
  println(sumit)

}
