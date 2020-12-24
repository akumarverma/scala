package com.akv.basic

object EX015_05_Sealed_Class extends App{

  /*
   * a sealed class can't have subclass in other files
   * pattern matching against a class inherit from selaed class give warning if all matching cases are not
   * taken into account
   * sealed keyword is often a licence of pattern matching
  */

  // eg.-9: pattern matching using class
  sealed abstract class Expr

  case class Val(name: String) extends Expr

  case class Number(name: Int) extends Expr

  case class UnOp(op:String,name:Int) extends Expr

  case class BinOP(op:String,a:Int,b:Int) extends Expr

  def exprClassMatching(e: Expr): String ={
    e match {
      case Val(_) => "A Variable "
      case Number(_) => "A Number"
    }
  }

  println(exprClassMatching(Val("Amit")))
  /* give warning
    * “warning: match is not exhaustive!
    * missing combination           UnOp
    * missing combination          BinOp”
    * to avoid warning use @ unchecked annotation
    *
  */

  def exprClassMatching2(e: Expr): String ={
    (e: @ unchecked) match {
      case Val(_) => "A Variable "
      case Number(_) => "A Number"
    }
  }
  println(exprClassMatching2(Val("Amit")))
}
