package com.akv.basic

object EX006_01_Rational_Number_Class extends App {
  /*
  * scala class definition takes parameters used to construct object
  * Anything not part of method in class are part of constructor
  * pre-condition: require(...), failing require will stop object construction
  * Auxiliary constructor: Class has can multiple auxiliary constructor but all will end up in calling
  * primary constructor
  * only primary constructor can invoke super constructor
  * Scala allows to use natural operator as methods such as +,-,*,/ etc
  * other point - method overloading, implicit conversion
   */

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
