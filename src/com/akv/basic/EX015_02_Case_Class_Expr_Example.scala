package com.akv.basic


object EX015_02_Case_Class_Expr_Example extends App{

  abstract class Expr
  case class Var(name:String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, args: Expr) extends Expr
  case class BinOP(operator: String, left: Expr,right:Expr) extends Expr

  val v = Var("X")
  println(v)
  println(v.name)

  val binOp = BinOP("+",Number(1),v)
  println(binOp)
  println(binOp.left)

  // Pattern matching using case class

  def matchPattern(expr: Expr):Any = expr match{
    case UnOp("-",UnOp("-",e)) => "Double unary operation"
    case BinOP("+",e,Number(0)) => "Adding Zero"
    case BinOP("*",e,Number(1)) => "Multiply by One"
    case _ =>
  }

  println(matchPattern(UnOp("-",UnOp("-",Var("5")))))
  println(matchPattern(BinOP("+",Var("5"),Number(0))))
  println(matchPattern(BinOP("*",Var("5"),Number(1))))

  // difference in Java switch and Scala match
  /*
  * switch expr {} vs expr match {}
  * scala match is a expression
  * no need of having break
  * MatchError is thrown if no match case found
   */

}
