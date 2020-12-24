package com.akv.basic

object EX002_01_Var_Val_Function extends App{

  /*
  * val : can not be re-assigned(similar as final in Java)
  * var : can be reassigned ( non-final in java)
   */

  val amit = "Amit"  // Type is inferred implicitly as String
  val shubh:String = "Shubh" // explicit type declaration


  def addA (x:Int,y:Int): Int = {
    x+y
  }

  def addB (x:Int,y:Int)= {
    x+y
  }

  def addC (x:Int,y:Int)=  x+y

}
