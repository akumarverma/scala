package com.akv.advance

object EX020_01_Abstract_Members extends App{

  /*
  * scala allows fields, types, methods to be abstract in addition to methods
   */

  // eg.1 : Abstract
  trait abs {
    type T
    def transform(x:T): T
    val initial:T
    var current : T
  }

  class sub extends abs{
    type T= String                // T == String, Can we used only in class and traits
    def transform(x:T): T = x+x
    val initial:T = "hi"
    var current : T = initial
  }

  // eg.2 : vals
  /*
  * val initial:T = "Hi" is same as
  * def initial:T = "Hi"
  * abstract def can either be implemented as val or def
  * but abstract val can not be defined as def
  * def -> val is fine, but val -> def will not compile
   */

  trait Apple{
    val v:String
    def m:String
  }

  class GoodApple extends Apple{
    val v:String = "Healthy Apple"
    val m:String = "Def as val"
  }

//  class BadApple extends Apple {
//    def v:String = "Not good, val can not be def"    // will not compile
//    val m:String = "It is ok for def to val"
//  }

  // eg. 3: vars
  trait AbstractTime{
    var hour:Int
    var minute: Int
  }
  trait AbstractTime2{
    def hour:Int             // getter for hour
    def hour_=(x:Int):Unit   // setter for hour
    def minute: Int          // getter for minute
    def minute_=(x:Int):Unit // setter for minute
  }
  // both AbstractTime and AbstractTime2 are same
}
