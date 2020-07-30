package com.akv.udemy.basic.lectures.patternMatching

import scala.util.Random

object EX026_patternMatching extends App{

  // Constant matching
  val rand = new Random()
  val x= rand.nextInt(10)
  val desc = x match {
    case 1=> "One"
    case 2=> "two"
    case _ => "More than 2"
  }
  println(s"$x $desc")

  // variable matching
  val varDesc = x match {
    case a if (a %2 ==0) => "Even"
    case a if (a %2 !=0) => "Odd"
    case _ => "??"
  }
  println(s"$x $varDesc")

  // de-structuring
  case class Person(name:String, age:Int)
  val amit = Person("Amit",42)

  val desc3 = amit match {
    case Person(n,a) => s"I am a Person Object. My name is $n and age is $a"
    case _ => "I don't know who i am"
  }
  println (desc3)

  // subclass matching
  sealed class Animal
  case class Dog() extends Animal
  case class Parrot() extends Animal

  val tommy: Animal = Dog()
  val animalType = tommy match{
    case Parrot() => "it is a parrot"
    case Dog() => "it is a dog"
    case _ => "??"
  }
  println(animalType)

  // Tuple matching
  val aTuple = Tuple2(1,2)
  val aMatch = aTuple match{
    case (1,1) => "one by 1"
    case(a,2)  => s"This is $a by 2"
  }

  val aNestedTuple = Tuple2(1,(2,3))
  val aNestedMatch = aNestedTuple match{
    case (1, (1, 1)) => "1,1,1"
    case (_,(2,v))  => s"This is (_,(2,$v)) by 2"
  }
  println(aNestedMatch)

  // List matching
  val aList = List(1,2,3,4,5)
  val aListMatching = aList match {
    case List(1,_,_,_,_) => "list starting with 1 and four other element"
    case List(1,_*) => "list starting with 1 and arbitrary number of element"
    case 1 +: List(_,_,_,_) => "prefixing 1 to a list"
    case List(1,2,3) :+ 4 => "appending 4 to list"
    case _ => "??"
  }
  println(aListMatching)

  // type matching
  val aStringList:List[String] = List("Amit","Swati","Shubh","Prisha")
  val typeMatching = aStringList match{
    case list: List[Int] => "A integer list: "+list
    case list: List[Char] => "A char List"
    case list: List[String] => "A string List"
  }
  println(typeMatching)


}
