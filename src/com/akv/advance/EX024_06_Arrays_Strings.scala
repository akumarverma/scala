package com.akv.advance

object EX024_06_Arrays_Strings extends App{
  /*
  * Arrays are generic in Scala
  * It is compatible with Seq so it can use all Seq methods
  * Array to Seq implicitly conversion result in ArraySeq
  * String also uses StringOps class for implicit conversion
  * Equality in collections depends on Category and elements
  * List(1,2,3) != Set(1,2,3) since Set and List are different category
  * whereas List(1,2,3) == Vector(1,2,3) and HashSet(1,2) = TreeSet(2,1)
  * Mutable and immutable are comparable
   */

  val a1 = Array[Int](1,2,3)

  val a2 = a1.map(_*3)

  val seq: scala.collection.mutable.Seq[Int] = a2

  println(seq)  // seq is ArraySeq

  // String
  val str = "Amit"
  println(str.map(_.toUpper))

}
