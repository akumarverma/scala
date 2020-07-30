package com.akv.basic

object EX010_FractionClass extends App {

  class Fraction(x: Int, y: Int) {

    require(y != 0)
    private val g = gcd(x.abs, y.abs)

    val numerator: Int = x / g
    val denominator: Int = y / g

    override def toString: String = {
      s"$numerator/$denominator"

    }

    def +(anotherFraction: Fraction): Fraction = {

      new Fraction(this.numerator * anotherFraction.denominator + this.denominator * anotherFraction.numerator,
        this.denominator * anotherFraction.denominator)
    }

    def +(int: Int): Fraction = {

      new Fraction(this.numerator  + this.denominator * int,
        this.denominator)
    }

    def -(anotherFraction: Fraction): Fraction = {

      new Fraction(this.numerator * anotherFraction.denominator - this.denominator * anotherFraction.numerator,
        this.denominator * anotherFraction.denominator)
    }

    def -(int: Int): Fraction = {

      new Fraction(this.numerator  - this.denominator * int,
        this.denominator)
    }

    def *(anotherFraction: Fraction): Fraction = {

      new Fraction(this.numerator * anotherFraction.numerator,
        this.denominator * anotherFraction.denominator)
    }

    def *(int: Int): Fraction = {

      new Fraction(this.numerator * int,
        this.denominator )
    }

    def /(anotherFraction: Fraction): Fraction = {

      new Fraction(this.numerator * anotherFraction.denominator,
        this.denominator * anotherFraction.numerator)
    }

    def /(int: Int): Fraction = {

      new Fraction(this.numerator ,
        this.denominator * int)
    }

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  }


  val x = new Fraction(1, 2)
  val y = new Fraction(2, 3)

  println(x)
  println(y)
  val xPlusY = x + y
  val xMinusY = x - y
  val xMultiplyY = x * y
  val xDivideY = x / y

  println(s"value of add, minus, multiply and divide is $xPlusY $xMinusY $xMultiplyY $xDivideY")

  val z = 5

  val xPlusZ = x + z
  val xMinusZ = x - z
  val xMultiplyZ = x * z
  val xDivideZ = x / z

  println(s"value of add, minus, multiply and divide is $xPlusZ $xMinusZ $xMultiplyZ $xDivideZ")


}
