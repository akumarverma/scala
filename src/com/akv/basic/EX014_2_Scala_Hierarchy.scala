package com.akv.basic

object EX014_2_Scala_Hierarchy extends App {

  /*
  * chapter Notes:
  * -------------
  * Any is parent of all class is scala
  * AnyVal is parent of : Byte, Short, Int, Long, Float, Double, Character, Boolean and Unit
  * AnyRef is parent of : String, Iterable etc..
  * AnyRef === java.lang.object

  * Nothing is subclass of all class
  * Null is subclass of all ref classes

  * All class inherit methods such as == != hasCode toString equals from Any

   */

  // Ex 1: Implicit conversion
  /*
  * scala.runtime,.richInt defines max, min, to, until operations
  * scala.runtime,.richIn also defines an implicit conversion from Int to RichInt
  * it means we can use max min to until operators on Int
  */

  println(42 max 43)
  println(42 min 39)
  println(1 to 5)
  println(1 until 5)

  // EX 2 equality
  def isEqual(x:Int,y:Int): Boolean = x==y

  println(isEqual(34,34))

  println(34==34)  // value comparision

  println(new String("abc") eq new String("abc")) // reference comparision


  // Ex 3 Null and Nothing

  val x = null

  println(x)

  def error(e:String):Nothing = throw new RuntimeException(e)

  def division(x:Int,y:Int):Int ={     // else returns Nothing whereas if returns Int
    if (y!=0) x/y
    else error("value of y can't be 0")
  }

  println(division(12,3))
  // println(division(12,0))   //throw exception

  // Ex 4 defining own custom val

  /*
  * No other class can extends custom value class
  * Must have exactly one parameter
  * Value class can't redefine hasCode and equals
  * Can't have anything except defs
  */

  class Dollar(val amount:Int) extends AnyVal {
    override def toString: String = "$" + amount
  }

  println(new Dollar(100))

  class SwissCurrency(val amount:Int) extends AnyVal {
    override def toString: String = s"$amount CHF"
  }

  println(new SwissCurrency(100))





}
