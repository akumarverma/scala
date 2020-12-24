package com.akv.basic

object EX012_04_Linearization extends App{

  class Animal
  trait Furry extends Animal
  trait HasLegs extends Animal
  trait FourLegs extends HasLegs
  class Cat extends Animal with FourLegs with Furry

  /*
  Animal -> AnyRef -> Any
  Furry -> Animal -> AnyRef -> Any
  HasLegs -> Animal -> AnyRef -> Any
  FourLegs -> HasLegs -> Furry -> Animal -> AnyRef -> Any
  Cat -> FourLegs -> HasLegs -> Furry -> Animal -> AnyRef -> Any

  */

  /*
  abstract class vs Traits
  Class -> thing, Trait -> behaviour
  if reusable behaviour -> Traits
  if inherit from java -> Abstract class
  not sure -> user traits since traits opens more options

   */

}
