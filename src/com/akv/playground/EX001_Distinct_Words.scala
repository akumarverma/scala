package com.akv.playground

object EX001_Distinct_Words extends App{

  val sentence ="see spot run.see,spot run see see.stop!"
  val words = sentence.split("[ ,.!]").toList

  println(words)

  val distinctWord = Set()++ words

  println(distinctWord)

}
