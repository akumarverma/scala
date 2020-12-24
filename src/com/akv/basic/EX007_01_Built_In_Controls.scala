package com.akv.basic
import scala.io.Source

object EX007_01_Built_In_Controls extends App() {
  /*
  * scala built in control structure: if, while, for, try match
  * all controls result in value, they are expressions
  * while and do-while are loops not expression, they don't return a value
   */

  //imperative vs functional style

  val x= 15
  val y = 3
  // imperative style using var
  var result = 0
  if (y==0) result =0
  else result = x/y
  println(result)
  // functional style using val
  val res = if(y==0) 0 else (x/y)
  println(res)

  // while Loops

  // imperative style
  def gcd(x:Int,y:Int) ={
    var a =x
    var b = y
    while (b!=0){
      val z = a % b
      a = b
      b = z
    }
    a
  }

  println(gcd(30,10))

  // functional style
  def gcd2(x:Int, y:Int):Int = if (y==0) x else gcd2(y,x%y)

  println(gcd2(30,10))

  //
  def hiDef = println("Hi")

  val hi = hiDef
  val isHi = if (hi=="Hi") 1 else 0 // hi type is unit si it will retuen false
  println(isHi)

}
