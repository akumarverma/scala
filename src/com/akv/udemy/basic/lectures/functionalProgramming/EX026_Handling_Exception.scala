package com.akv.udemy.basic.lectures.functionalProgramming

import scala.util.{Failure, Success, Try}

object EX026_Handling_Exception extends App{
  val aSuccess = Success(4)
  val aFailure = Failure(new RuntimeException("A runtime error"))
  println(s"$aSuccess $aFailure")

  def  anUnsafeMethod: String = throw new RuntimeException("Amit-> Exception caught")
  val potentialFailure = Try(anUnsafeMethod)
  println(potentialFailure)
  println(potentialFailure.isFailure)
  println(potentialFailure.isSuccess)


}
