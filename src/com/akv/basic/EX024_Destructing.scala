package com.akv.basic

object EX024_Destructing extends App{

  val countries = List("Finland","India","Sweden")
  val List(country1,country2,country3)  = countries
  println(country1)
  println(country2)
  println(country3)

  val country4::country5::rest  = countries
  println(country4)
  println(country5)
  println(rest)

}
