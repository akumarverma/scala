package com.akv.udemy.advance.implicits

object Ex001_01_Implicits extends App{
  /*
  * -> is defined in ArrowAssoc class
  * if there are more than one implicit, it will not compile
  * Implicit used a parameters
  * 1. var/val 2. objects 3. parameterless def
  * Implicit Scope:
  * 1. Local
  * 2. Imported
  * 3. Companion of all type involved in method signature
  * if multiple ordering exists, define each  in objects and import it
   */

  // ex. 1: Arrow function is defined in ArrowAssoc class
  val amit = "Amit" -> 43  // final implicit class ArrowAssoc
  val one = 1 -> "One"

  // ex. 2: String to Person class implicit
  case class Person(name:String){
    def greet = s"Hi, My name is $name"
  }

  implicit def stringToPerson(str:String):Person = Person(str)

  println("Amit".greet)  // stringToPerson("Amit").greet

  // eg.3 : implicit function parameters
  def add(x:Int)(implicit y:Int): Int = x+y

  implicit val defaultVal = 10

  println(add(5))  // y takes defaultVal as implicit argument

  println(add(5)(20))

  //ex 4. ordering
  implicit def reverseOrdering: Ordering[Int] = Ordering.fromLessThan(_>_)

  println(List(4,2,6,4,8,10,1).sorted)

  // eg 5. sorting objects

  case class Family(name:String, age:Int)

  val family_members = List(Family("Amit",42),Family("Swati",38),Family("Shubh",11),Family("Prisha",1))

  // sorting by name
  //implicit def familyOrdering: Ordering[Family]=  Ordering.fromLessThan((a,b) => a.name.compareTo(b.name)>0)

  // sorting by age
  implicit def familyOrdering: Ordering[Family]=  Ordering.fromLessThan((a,b) => a.age<b.age)

  println(family_members.sorted)

}
