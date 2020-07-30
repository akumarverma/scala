package com.akv.udemy.basic.lectures.oop

object EX009_Inheritance extends App{

  class Animal(val creatureType: String){
    def eat():String = "Animals eats"

    protected def feet(legs:Int):Int = legs // Not accessible directly, can we accessed in subclass methods
  }

  class Cat(override val creatureType: String /*overloading */) extends Animal(creatureType){

    override def feet(legs: Int): Int = super.feet(legs)

  }
  val cat = new Cat("Domestic")
  println(cat.eat())
  println(cat.feet(4))
  println(cat.creatureType)

  class Person(name:String, age:Int){
    def ageDescription() = s"I am a person aged $age"
    final def finalMethod = println("This can't be overridden")
    override def toString: String = {
      s"$name $age"
    }
  }

  class Adult(name:String, age:Int,val idCard:String) extends Person(name,age) {

    override def ageDescription() = s"I am an adult aged $age"
    override def toString: String = {
      super.toString + " " + idCard
    }
  }

  val amit:Person = new Adult("Amit",42,"12345")

  println(amit)
  println(amit.ageDescription()) // Polymorphism, calling subclass method
  amit.finalMethod

  val shubh:Person = new Person("Amit",42)

  println(shubh)
  println(shubh.ageDescription()) // Polymorphism, calling parent class method
  shubh.finalMethod


  // selaed class can be extended only in current file



}
