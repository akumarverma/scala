package com.akv.udemy.basic.lectures.oop

object EX012_Generics extends App{

  class MyList[A]{
    def add(element:A):Unit = println(s"Added $element")
  }

  val intList = new MyList[Int]
  intList.add(5)

  val stringList = new MyList[String]
  stringList.add("Amit")

  class Animal
  class Cat extends Animal
  class Dog extends Animal
  val cat = new Cat
  var list:List[Animal] = List[Cat](cat)

  // Covariant
  class CovariantList[+A]
  val covariantList: CovariantList[Animal]= new CovariantList[Cat]()

  // invariant
  class InvariantList[A]
  val invariantList: InvariantList[Cat]= new InvariantList[Cat]()

  // ContraVariant
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat]= new ContravariantList[Animal]()

  // lower bound Types
  class BoundedList[+A](animal: Animal){
    def add[B>:A](element:B): List[B] = List(element)
  }

  val aCatList = new BoundedList(new Cat)
  val aDogList = new BoundedList(new Dog)
  println(aCatList.add(new Dog))


}
