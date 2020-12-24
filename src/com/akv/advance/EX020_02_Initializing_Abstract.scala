package com.akv.advance

object EX020_02_Initializing_Abstract extends App{

  trait RationalTrait{
    val numerArg:Int
    val denomArg:Int
    override def toString: String = ""+ numerArg+"/"+denomArg
  }

  val oneByTwo = new RationalTrait {
    override val numerArg: Int = 1
    override val denomArg: Int = 2
  } // Anonymous Class

  println(oneByTwo)  // this will work fine

  trait RationalTrait2{
    val numerArg:Int
    val denomArg:Int
    require(denomArg!=0)
    override def toString: String = ""+ numerArg+"/"+denomArg
  }

  val oneByTwo2 = new RationalTrait2 {
    override val numerArg: Int = 1
    override val denomArg: Int = 2
  } // it will fail

  /*
  * class parameters are evaluated before object is initialized
  * whereas abstract vals are evaluated as part of initialization
  * at the time of abstract value initialization, demonArg is 0, so the require is failing
  * An implementing val in subclass is evaluated only after super is initialized
  * Scala solution: pre-initialized fields/Lazy vals
   */


}
