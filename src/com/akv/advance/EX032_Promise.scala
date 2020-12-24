package com.akv.advance

import scala.concurrent.Promise

object EX032_Promise extends App{
  /*
  * Promise is a controller of Future
  * once the promise is fulfilled, future is also completed
   */

  val promiseSuccess = Promise[Int]
  val futSuccess = promiseSuccess.future
  promiseSuccess.success(42)
  println(futSuccess.value)

  val promiseFailure = Promise[Int]
  val futFailure = promiseFailure.future
  promiseFailure.failure(new Exception("promise broken... "))
  println(futFailure.value)

}
