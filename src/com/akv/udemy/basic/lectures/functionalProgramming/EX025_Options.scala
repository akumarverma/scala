package com.akv.udemy.basic.lectures.functionalProgramming

object EX025_Options extends App{

  val someOption: Option[Int] = Some(4)
  val noneOption: Option[Int] = None

  println(s"$someOption $noneOption")

  def unsafeMethod: String = null

  val result = Option(unsafeMethod)

  println(result)

}
