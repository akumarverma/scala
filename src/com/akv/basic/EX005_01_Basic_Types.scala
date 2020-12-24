package com.akv.basic

object EX005_01_Basic_Types extends App{

  /*
  Any -> AnyVal -> Byte,short,int,long,float,double,char,boolean,unit

   */

  val aByte: Byte =127
  val aShort: Short = 12345
  val aInt: Int = 324983
  val aLong: Long = 123456L
  val aFloat: Float = 1.234f
  val aDouble: Double = 3.1414
  val aChar: Char = 'a'
  val aTruthy: Boolean = true
  def aDef():Unit = println("A unit")

  println(s"$aByte $aShort $aInt $aLong $aFloat $aDouble $aChar $aTruthy")
  aDef()

  val aLongString =
    """a long string
      |spanning to multiple line
      |now let us conclude
      |""".stripMargin

  println(aLongString)



}
