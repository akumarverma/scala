package com.akv.basic

object EX005_03_Infix_PreFix_PostFix_Operator extends App {

  val a =5
  val b =4

  // infix operator, operator sits between object and parameter
  val c = a + b

  println(s"value of c is $c")

  val d = a.+(b)

  println(s"value of d is $d")

  // prefix operators(unary) + - ! ~

  val e = +a //5
  val f = -a //5
  val g = !true
  val h = ~20

  println(s" value if e,f g and h are: $e $f $g $h")

  val e1 = a.unary_+
  val f1 = a.unary_-
  val g1 = true.unary_!
  val h1 = 20.unary_~
  println(s" value if e1,f1 g1 and h1 are: $e1 $f1 $g1 $h1")

  // Postfix operators, take no parameter
  val name = "amit"

  println(name.toUpperCase())

  println(name.toUpperCase)

  // Arithmetic operator: + - * / %
  // relational Operator: > >= < <= != == !
  // Logical Methods && ||

  // object equality

  println(1==1)   // true
  println(1!=2)   // true
  println(List(1,2,3)== List(1,2,3))  // true
  println(List(1,2,3)== List(4,5,6))  // false
  println(1== 1.0) // true
  println(List(1,2,3)== null) // false

  // == method in scala invokes equals method

}
