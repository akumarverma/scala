package com.akv.udemy.advance.implicits

import com.akv.udemy.advance.implicits.EX006_01_Advance_Inheritance.{A, B, C}

object EX006_01_Advance_Inheritance extends App {
/*
 * a class can inherit multiple traits and classes
 */

  // ex: 1
  trait A{
    def a()= print("A")
  }

  trait B{
    def b()= print("B")
  }

  trait C{
    def c()= print("C")
  }

  def f(abc: A with B with C)= {
    abc.a()
    abc.b()
    abc.c()
  }

  class ABC extends A with B with C

  val abc = new ABC

  f(abc)

  //eg.2
  trait Animal {
    def print = {println("Animal")}
  }

  trait Lion extends Animal {
    override def print: Unit = {println("Lion")}
  }

  trait Tiger extends Animal {
    override def print: Unit = {println("Tiger")}
  }

  class Alien extends Lion with Tiger{
    override def print: Unit = {
      println("Alien")
      super.print   // last override get picked
    }
  }
 println()
 (new Alien).print

  //eg. 3
  trait Color {
    def print: Unit = {println("Color")}
  }

  trait Green extends Color{
    override def print: Unit = {println("Green");super.print}
  }

  trait Blue extends Color {
    override def print: Unit = {println("Blue");super.print}
  }

  class Red {
    def print: Unit = {println("Red")}
  }

  class White extends Red with Green with Blue{
    override def print: Unit = {
      println("White")
      super.print
    }
  }
  println()
  (new White).print
  /*
  * it prints:
  * White
  * Blue
  * Green
  * Color
  * where is RED?
  * the answer is type linearization
  * Color -> AnyRef
  * Green -> AnyRef
  * Blue  -> AnyRef
  * white -> Red -> AnyRef
  * white -> Blue -> Green -> Color -> AnyRef
  * white -> Blue -> Green -> Color -> Red -> AnyRef
   */


}
