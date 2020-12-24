package com.akv.basic

object EX012_01_Traits extends App{
  /*
  * traits are similar as java interface. it can have concrete methods and fields.
  * it can not be instantiated, so will not take parameters.
  *
   */

  trait Philosophical {
    def philosophize() = println("I consume memory, therefore I am")
  }

  class Frog extends Philosophical{
    override def toString: String = "green"
  }

  val frog:Frog = new Frog   // Class as Type
  frog.philosophize()
  println(frog)

  val frog2:Philosophical = new Frog // Trait as Type
  frog2.philosophize()
  println(frog2)

  class Animal
  trait hasLegs

  class X extends Animal with hasLegs with Philosophical // Class extending Class and mixing multiple traits

  // Traits can not take arguments
}
