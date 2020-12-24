package com.akv.basic

object EX012_02_Ordered_Traits extends App {

  /*
  * Ordered trait provide methods to compare such as <, >,<= and >=
  * need to define abstract "compare" method in implementing class
  */

  class Rational(val x:Int, val y:Int) extends Ordered[Rational] {
    override def compare(that: Rational): Int = this.x* that.y - this.y * that.x
  }

  val oneHalf = new Rational(1,2)
  val oneThird = new Rational(1,3)

  println(oneHalf< oneThird)
  println(oneHalf<= oneHalf)
  println(oneHalf>= oneThird)
  println(oneThird> oneThird)

}
