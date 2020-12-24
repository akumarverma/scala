package com.akv.basic

object EX015_06_Option_Some_None extends App {

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

  // similar as Above but using val
  val getCapital:Option[String] => String ={
    case Some(x) => x
    case None => "?"
  }

  println(getCapital(capitals.get("Finland")))
  println(getCapital(capitals.get("India")))
  println(getCapital(capitals.get("Estonia")))
}
