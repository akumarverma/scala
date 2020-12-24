package com.akv.advance

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object EX032_02_Future_Map extends App{

  /*
  * A transformation can be applied on future to produce another future
  * we can use map, flatmap to do this
  * if futures are defined before  nested for loop, it will execute in parallel
  * if defined inside for loop, it will run in sequence
   */

  val futureFirst = Future {
    Thread.sleep(100)
    42
  }

  val futureSecond = futureFirst.map(_+1)
  Thread.sleep(150)
  println(futureSecond.value)

  //eg. 2
  val fut1 = Future{Thread.sleep(100);5}
  val fut2 = Future{Thread.sleep(100);6}

  val sum = for (x<- fut1;
                y<- fut2) yield x+y

  Thread.sleep(150)
  println(sum)

  //eg. 3, Future defined inside for so will run in sequence
  val sum2 = for (x<- Future{Thread.sleep(100);5};
                 y<- Future{Thread.sleep(100);6}) yield x+y

  Thread.sleep(250)
  println(sum2)

}
