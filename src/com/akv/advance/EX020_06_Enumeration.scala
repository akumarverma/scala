package com.akv.advance

object EX020_06_Enumeration extends App{

  object Grade extends scala.Enumeration{
    val g_1 = Value("I")
    val g_2 = Value("II")
    val g_3 = Value("III")
    val g_4 = Value("IV")
    val g_5 = Value("V")
  }

  for (i <- Grade.values) println(i)

  println(Grade.g_3)      // value of key
  println(Grade.values)   // list of values
  println(Grade.g_3.id)   // index of key
  println(Grade(1))       // Value at Index


}
