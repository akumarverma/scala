package com.akv.udemy.basic.lectures.oop

object EX010_Abstract_and_Traits extends App {

  abstract class Animal {
    val creatureType:String
    def eat:String
  }

  class Cat extends Animal{
    override  val creatureType:String = "Domestic" // override is optional
    def eat:String   = "crunch crunch"
  }

  trait Carnivore{
    def eat(animal: Animal):String
  }

  val cat = new Cat
  println(s"${cat.creatureType} ${cat.eat}")

  class Crocodile extends Animal with Carnivore{
    val creatureType:String = "Croc" // override is optional
    def eat:String   = "nom nom nom"
    def eat(animal: Animal): String = s"i am a $creatureType and i eat ${animal.creatureType} animals"
  }

  val crocodile = new Crocodile
  println(s"${crocodile.creatureType} ${crocodile.eat} ")
  println(s"${crocodile.eat(cat)}")

  // Traits vs Abstract Class
  //1. Traits can't have constructor parameters
  //2. class can extends one abstract class but multiple traits
  //3. Traits == behaviour, Class == Objects

}
