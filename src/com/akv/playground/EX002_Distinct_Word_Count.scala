package com.akv.playground

object EX002_Distinct_Word_Count extends App{

  val sentence ="see spot run.see,spot run see see.stop!"
  val words = sentence.split("[ ,.!]").toList
  val wordCount = scala.collection.mutable.Map[String,Int]()
  for (word <- words){
    if (wordCount.contains(word)){
      wordCount(word) = wordCount(word)+1
    }
    else{
      wordCount+= (word->1)
    }
  }
  println(wordCount)
}
