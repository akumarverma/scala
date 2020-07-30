package com.akv.basic

object EX022_Math_Operations extends App {

  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String,left: Expr, right: Expr ) extends Expr
  // Test few objects of above defined
  val varObj = Var("x")
  println(varObj)

  val binObj = BinOp("+",varObj,Number(5))
  println(binObj)

  // Adding trivial expression behaviour
  def simplifyOp(expr: Expr): Expr ={
    expr match {
      case UnOp("-",UnOp("-",e)) => e
      case BinOp("+",e,Number(0)) => e
      case BinOp("*",e,Number(1)) => e
      case BinOp("*",e,Number(0)) => Number(0)
      case BinOp("-",_,_) => Var("Method Not Implemented") //use of wildcard to discard unused pattern variables
      case _ =>Var("Something nasty!!!")
    }
  }

  val expr = simplifyOp(UnOp("-",UnOp("-",Number(5))))
  println(expr)

  val expr2 = simplifyOp(BinOp("+",Number(5),Number(0)))
  println(expr2)

  val expr3 = simplifyOp(BinOp("*",Number(5),Number(1)))
  println(expr3)

  val expr4 = simplifyOp(BinOp("-",Number(5),Number(1)))
  println(expr4)

  val expr5 = simplifyOp(BinOp("/",Number(5),Number(1)))
  println(expr5)

}
