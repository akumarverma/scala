package com.akv.udemy.advance.patternMatching

object EX001_Unapply extends App {

  class Person(val name:String,val age:Int)

  object Person{
    def unapply(person: Person):Option[(String, Int)] ={
      Some(person.name,person.age)
    }

    def unapply(age: Int):Option[(String)] ={
      if (age <= 18) Some("Minor") else Some("Major")

    }
  }

  val amit = new Person("Amit",42)

  val aMatch = amit match {
    case Person(n,a) => s"I am a person and my name is $n and age is $a"
    case _ => "??"
  }

  println(aMatch)

  val aAgeMatch = amit.age match {
    case Person(status) => s"I am a person and my status is $status"
    case _ => "??"
  }

  println(aAgeMatch)

  object Even {
    def unapply(num:Int): Boolean ={
      num%2==0
    }
  }

  object singleDigit {
    def unapply(num:Int): Boolean ={
      num.abs<=10
    }
  }

  val aIntMatch = 16 match{
    case singleDigit() => "Single Digit"
    case Even() => "Even"
    case _ => "??"
  }
  println(aIntMatch)

}
