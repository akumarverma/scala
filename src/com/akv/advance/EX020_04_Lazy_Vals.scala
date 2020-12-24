package com.akv.advance

object EX020_04_Lazy_Vals extends App{

  /*
  * the vals with Lazy qualifier will be initialized when first referenced
  * Order of initialization doesn't matter
   */

  object Demo {
    val x = {println("Initializing x"); "done"}
  }

  println(Demo)  // x is initialized as part of Demo

  object Demo2 {
    lazy val x = {println("Initializing x"); "done"}
  }

  println(Demo2)  // x is not initialized

  println(Demo2.x) // x is initialized here once referred

}
