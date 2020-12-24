package com.akv.basic

object EX002_02_Loops extends App{

  val family = List("Amit","Swati","Shubh","Prisha")

  // Imperative style
  var i =0
  while(i<family.length) {
    println(family(i))
    i+=1
  }

  // scala style
  println("\n\nOption 1")
  family.foreach(x => println(x))  // x => println(x) is function literals
  println("\n\nOption 2")
  family.foreach(println(_))
  println("\n\nOption 3")
  family.foreach(println)

  // using for
  println("\n\nOption 4(using for)")
  for(member <- family)
    println(member)

  // member in for is a val not var, it get new value in each iteration


}
