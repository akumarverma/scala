package com.akv.udemy.basic.lectures.functionalProgramming

object EX021_Map_Filter_flatMap_for extends App{

  val numList = List(1,2,3,4)
  val charList = List('a','b','c','d')
  val color = List("Black","white")

  println(s"$numList $charList")

  // Map
  println(numList.map(_+1))

  val pairedList = (x:Int) => List(x,x+1)
  println(pairedList)

  // filter
  println(numList.filter(_%2==0))

  // flatMap
  println(numList.flatMap(pairedList))

  println(numList.flatMap(n=> charList.flatMap(c => color.map(col => ""+c+n+"-"+col))))

  val combo = for {
    n <- numList;
    c <- charList;
    col <- color
  } yield ""+c+n+"-"+col

  println(combo)

}
