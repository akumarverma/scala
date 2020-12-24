package com.akv.basic

object EX008_04_Closure extends App{

  var more:Int = 3

  val addMore = (x:Int) => x+more  // x is "bound" variable whereas more is "free variable"

  println(addMore(4))

  // above is equivalent to
  object closureObject {
    def apply(a:Int): Int = a+more
  }

  println(closureObject(1))
  more =7
  println(closureObject(1))


}
