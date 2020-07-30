package com.akv.basic

object EX023_Option_Some_None extends App {

  val capitals = Map("Finland"->"Helsinki","India"->"New Delhi","Sweden"->"Stockholm")
  println(capitals.get("Finland")) // Map get returns "some()" if found
  println(capitals.get("Estonia")) // Map get returns "None" if not found

  // using pattern matching
  def foundCapital(x: Option[String]): String = x match{
    case Some(x) => x
    case None => "?"
  }

  println(foundCapital(capitals.get("Finland")))
  println(foundCapital(capitals.get("India")))
  println(foundCapital(capitals.get("Estonia")))
}
