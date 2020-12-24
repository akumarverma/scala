package com.akv.advance

object EX020_03_Pre_Initialized_Fields extends App{

  trait RationalTrait{
    val numerArg:Int
    val denomArg:Int
    require(denomArg!=0)
    override def toString: String = ""+ numerArg+"/"+denomArg
  }

  // using a object
  object oneByTwo extends {val numerArg=1
                          val denomArg=2
  } with RationalTrait

  println(oneByTwo)

  // using class
  class TwoByThree extends { val numerArg =2
    val denomArg=3
  } with RationalTrait

  println(new TwoByThree)
  // using a more generic class
  class Fraction(n:Int,d:Int) extends {
    val numerArg =n
    val denomArg = d
  } with RationalTrait

  println(new Fraction(1,2))
  println(new Fraction(2,3))

  // pre-initialized fields can't refer "this" since it is called before super initialization
}
