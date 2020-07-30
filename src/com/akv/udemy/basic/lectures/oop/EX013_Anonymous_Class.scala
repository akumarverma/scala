package com.akv.udemy.basic.lectures.oop

object EX013_Anonymous_Class extends App{

  class Animal( val name: String){
    def eat():Unit = println(s"My name is $name and i eat grass")
  }

  val aAnimal = new Animal("Cow")
  aAnimal.eat

  val aTiger = new Animal("Tiger"){
    override def eat(): Unit = println(s"My name is ${this.name} and i eat meat")
  }

  println(aTiger)
  aTiger.eat()

}
