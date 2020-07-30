package com.akv.udemy.basic.lectures.functionalProgramming

object EX023_Tuple_Maps extends App{

  // Tuples
  val tuple = ("Amit",123,"India")
  println(s"${tuple._1} ${tuple._2} ${tuple._3}")

  val duplicateTuple = tuple.copy(_1="Shubh")
  println(s"${duplicateTuple._1} ${duplicateTuple._2} ${duplicateTuple._3}")

  // Maps
  val aMap = Map(("Amit",42),"shubh"-> 10)
  val swati = Map("Swati"-> 38)
  println(s"$aMap $swati")
  println(aMap ++ swati)
  println(aMap.map(pair=>  pair._1+" verma"-> pair._2))
  println(aMap.filter(pair=>   pair._2==42))

  // type conversion
  println(aMap.toList)
  println(List(("prisha",2)).toMap)

}
