package com.akv.advance

object EX023_01_For_Expression_Revisited extends App{
  /*
  * high order functions such as - map, flatmap, filter
  * scala compiler translate for loops in high order functions
  * for (seq) expr -> seq has generator and optionally definition and filters
  * for (p <- persons n= p.name if(n.startsWith("A")) yields p.name
  * p <- persons --> generator
  * n= p.name --> definition
  * if(n.startsWith("A") --> filter

   */

  case class Person (name:String,isMale:Boolean, children : Person*)
  val prisha = Person("Prisha",false)
  val shubh = Person("Shubh",true)
  val swati = Person("Swati",false,shubh,prisha)
  val amit = Person("Amit",true,shubh,prisha)

  val persons = List(amit,swati,shubh,prisha)
  // find all women with their child
  val womenChildTupleList = persons.filter(!_.isMale).flatMap(p => p.children.map(c=> (p.name,c.name)))
  println(womenChildTupleList)

  val womenChildTupleList2 = for (p <- persons
                                 if (!p.isMale);
                                 c <- p.children) yield(p.name,c.name)
  println(womenChildTupleList2)


  /*
  * Translation of for loops
  * for (x <- expr1) yield expr2  -> expr1.map(x=> expr2)
  * for (x <- expr1 if expr2) yield expr3  -> expr1.withFilter(x=> expr2).map(x=> expr3)
  * for (x <- expr1; y <- expr2) yield expr3  -> expr1.flatMap(x=> for(y <- expr2)) yield expr3
  *                                              expr1.flatMap(x=> expr2.map(y<- expr3))

   */

}
