package com.akv.advance

import scala.concurrent.Future
import scala.util.{Failure, Success}

object EX032_Future_Companion extends App{

  /*
  * Future in addition to Apply, also provide Success, Failed and fromTry method
  * These factory method do not need a execution context
  * the values are already satisfied
   */

  val futSuccess = Future.successful(42)

  val futFailure = Future.failed(new  Exception("No...."))

  val futureTrySuccess = Future.fromTry(Success(42))

  val futureTryFailure = Future.fromTry(Failure(new Exception("No....")))

  println(s"$futSuccess $futFailure $futureTrySuccess $futureTryFailure")

}
