package com.akv.advance
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object EX032_01_Future_Concurrency extends App {

  /*
  * import scala.concurrent.Future, need to import execution context
  * scala.concurrent.ExecutionContent.Implicit.global
  * Future enable code to run asynchronously,returns a Option[Try[T]]
  * has isCompleted and value methods to check status and get the value
  * is completed return "false" and value returns "None" if not completed
  * try is either "Success" returning T or "Failure" returning exception
  * (Try is defined in scala.utils)
  *
   */

  val futureHello = Future{Thread.sleep(1000);"Hello concurrent world"}
  Thread.sleep(2000)
  println(futureHello.isCompleted)
  println(futureHello.value)

  val futureFailure = Future { Thread.sleep(1000); 1/0}
  Thread.sleep(1500)
  println(futureFailure.value)

}
