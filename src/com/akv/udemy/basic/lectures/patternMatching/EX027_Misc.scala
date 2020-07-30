package com.akv.udemy.basic.lectures.patternMatching

object EX027_Misc extends App{

  // Exception handling
  try{
    val a = throw new RuntimeException
  }
  catch{
    case e: RuntimeException => println("Rum time error")
    case _ => println("??")
  }

  val aList = List(1,2,3)
  val EvenProdTen = for(
    a <- aList if (a%2 ==0)
  ) yield a*10

  println(EvenProdTen)

  val tupleList = List((1,2),(2,3))
  val x = for(
    (a,b) <- tupleList
  ) yield a*b
  println(x)

  val (a,b,c) = Tuple3(1,2,3)
  println(b)

  val (h+:t) = aList
  println(s"$h $t")

  val aModifiedList = aList.map(x=> x match {
    case a if (a%2 ==0) => "an Even Number"
    case 1 => "One"
    case _ => "??"
  })

  println(aModifiedList)


}
