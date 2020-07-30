package com.akv.udemy.basic.lectures.basic

object EX001_Val_Var_types extends App {

  // different type of val(re-assignment is not allowed)
  val aByte: Byte =1
  val aShort: Short =1
  val aInt:Int =5
  val aLong:Long = 123L   // Type is optional
  val aFloat:Float = 1.2f
  val aDouble:Double = 1.2345
  val aBoolean: Boolean = false
  val aString: String = "Amit"

  val anImplicitInt = 1234567 // explicit Type declaration is not needed

  var aVarInt =5
  aVarInt=7 // re-assignment

  println(s"$aByte $aShort $aInt $aLong $aFloat $aDouble $aBoolean $aString $anImplicitInt $aVarInt")

}
