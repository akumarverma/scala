package com.akv.basic

object EX020_Varying_Named_default_Argument extends App{

  // Varying parameters
  def varyingParam(params : String*): Unit ={ // the type of params is Seq[String]
    for (param <- params){
      println(param)
    }
  }
  val seq: Seq[String] = Seq("my","name","is","Amit")

  varyingParam(seq: _*) // “This tells the compiler to pass each element of seq as its own argument”


  // named/default  parameters
  def speed(distance: Int=500, time: Int=1): Int ={
    distance/time
  }

  println(speed())
  println(speed(distance = 120, time=2))
  println(speed(distance = 45))
  println(speed(time = 5))


}
