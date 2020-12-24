package com.akv.advance

object EX021_01_Implicit_Conversion extends App{
  /*
  * All implicit conversion should be "Single Identifier" and in "scope"
  * No of useful conversion library is in preamble. import preamble._
  * Exception to "single Identifier" is implicit conversion in companion object
  * Map(1->"One",2->"Two"), -> is a method in class ArrowAssoc defined in scala.Predef
  * it also define a implicit conversion from Any to ArrowAssoc in order to use -> method

   */

  // Implicit conversion to an expected Type

  //eg.1
  implicit def doubleToInt(x:Double):Int = x.toInt
  val y:Int = 3.5 // val y:Int = doubleToInt(3.5)
  println(y)

  // eg.2 : Converting the receiver
  case class Rational(x:Int, y:Int){

    def +(that:Rational):Rational = {
       Rational(this.x * that.y+ that.x*this.y, this.y* that.y)
    }
    def +(that:Int):Rational = {
      Rational(this.x + that*this.y, this.y)
    }

    override def toString: String = s"$x/$y"
  }

  implicit def intToRational(x:Int):Rational = Rational(x,1)

  val oneHalf = Rational(1,2)
  println(oneHalf + oneHalf)
  println(oneHalf + 1)
  println(1+ oneHalf)

  // eg. 3: Implicit class

  case class Rectangle(x:Int,y:Int)

  implicit class RectangleMaker(val a:Int){
    def x(b:Int) =  Rectangle(a,b)
  }

  val myRectangle = 3 x 4

  println(myRectangle)




}
