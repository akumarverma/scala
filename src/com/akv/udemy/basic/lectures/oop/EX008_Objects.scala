package com.akv.udemy.basic.lectures.oop

object EX008_Objects extends App{

  object Person{
    val N_EYES: Int =2
    def canFly: Boolean = false

    // factory method
    def apply(name: String): Person = new Person(name)
  }
  // companion class
  class Person(name:String) {
    override def toString: String = name
  }

  val person = Person
  println(s"${person.N_EYES} ${person.canFly}")

  val amit = Person.apply("Amit")
  println(amit.toString)

  val shubh = Person("Shubh")
  println(shubh.toString)

}
