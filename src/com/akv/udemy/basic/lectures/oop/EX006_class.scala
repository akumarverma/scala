package com.akv.udemy.basic.lectures.oop

object EX006_class extends App {

  val shubh = new Author("Shubh","verma",2010)
  val prisha = new Author("Prisha","Verma",2019)
  val theNightmare = new Book("The Nightmare",2020,shubh)

  println(shubh)
  println(theNightmare)
  println(theNightmare.isWrittenBy(prisha))
  println(theNightmare.authorAge)
  theNightmare.copy(2025)
  println(theNightmare)

  val counter = new Counter
  println(counter)
  println(counter.incrementCounter)
  println(counter.incrementCounter(5))
  println(counter.decrementCounter(3))
  println(counter.decrementCounter)





}

class Author(val firstName:String, var lastName:String, val yob:Int){
  def fullName = firstName +" " + lastName

  override def toString: String = fullName
}

class Book(val name:String,var yearOfPublication:Int, val author:Author){
  def authorAge: Int = yearOfPublication- author.yob
  def isWrittenBy(anotherAuthor:Author): Boolean = (this.author.firstName == anotherAuthor.firstName &&
  this.author.lastName == anotherAuthor.lastName)
  def copy(newYearOfRelease:Int) = {this.yearOfPublication =newYearOfRelease}

  override def toString: String = this.name + " "+ this.yearOfPublication +" "+author.toString
}

class Counter(val count: Int=0){

  def incrementCounter:Counter = {
    // println("Incrementing value")
    new Counter(count+1)
  }
  def decrementCounter:Counter = {
    // println("decreasing value")
    new Counter(count-1)
  }
  def incrementCounter(amount:Int):Counter = {
    if (amount<=0) this
    else incrementCounter.incrementCounter(amount-1)
  }
  def decrementCounter(amount:Int):Counter = {
    if (amount<=0) this
    else decrementCounter.decrementCounter(amount-1)
  }

  override def toString: String = this.count.toString
}