package com.akv.basic

import scala.math.{E, Pi}

object EX017_Pattern_Matching extends App {

  // eg.-1: Constant and wildcard pattern
  val aOption = 2
  val aMatch = aOption match {
    case 1 => "one"
    case 2 => "two"
    case _ => "More than 2"
  }
  println(aMatch)

  // eg.-2: pattern matching math.Pi and math.E
  val aMathMatch: Any = E match {
    case Pi => "value of math PI is:" + Pi
    case E => "value of math E is:" + E
    case _ => "NOK"
  }
  println(aMathMatch)

  // eg.-3: pattern matching using variables
  val pi = Math.PI
  val aVarMatch: Any = pi match {
    case pi => pi
    case _ => "NOK"
  }
  println(aVarMatch)

  // eg.-4: pattern matching using seq

  def aSeqMatch(seq: Seq[Any]): Any = seq match {
    case List(_, _, _) => 1
    case _ => "NOK"
  }

  println(aSeqMatch(List(1, 2, 3)))
  println(aSeqMatch(List("a", "b", "c")))

  // eg.-6: pattern matching using seq with arbitrary parameters
  def aSeqMatch2(seq: Seq[Any]): Any = seq match {
    case List(0, _*) => 1
    case _ => "NOK"
  }

  println(aSeqMatch2(List(0, 1, 2, 3)))
  println(aSeqMatch2(List("a", "b", "c")))

  // eg.-7: pattern matching using tuple
  def aTupleMatch(tuple: (Int, Int, Int)): Any = tuple match {
    case (1, 2, 3) => "values are " + (1, 2, 3)
    case _ => "NOK"
  }

  println(aTupleMatch((1, 2, 3)))

  // eg.-8: pattern matching using Type
  def aTypeMatch(x: Any): Any = x match {
    case s: String => s"String value ${s} of length: " + s.length
    case m: Map[Any, Any] => s"Map value ${m} of size: " + m.size
    case _ => -1
  }

  println(aTypeMatch("Amit"))
  println(aTypeMatch(Map("Amit" -> "A", "Shubh" -> "S")))
  println(aTypeMatch(List()))

  // eg.-9: pattern matching using class
  sealed abstract class Expr

  case class Val(name: String) extends Expr

  case class Number(name: Int) extends Expr

  def exprClassMatching(e: Expr): Expr ={
    e match {
    case Val(name) => Val("this is Val Class "+name)
    case Number(num) => Number(num)
  }
  }
  println(exprClassMatching(Val("Amit")))
  println(exprClassMatching(Number(2)))

  // eg.-10: pattern matching using Option, Some and None
  val capitals = Map("Finland"->"Helsinki","India"->"New Delhi","Sweden"->"Stockholm")

  // using pattern matching
  def foundCapital(x: Option[String]): String = x match{
    case Some(x) => x
    case None => "?"
  }

  println(foundCapital(capitals.get("Finland")))
  println(foundCapital(capitals.get("India")))
  println(foundCapital(capitals.get("Estonia")))

}
