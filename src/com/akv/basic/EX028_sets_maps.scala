package com.akv.basic
import scala.collection.immutable.TreeSet

object EX028_sets_maps extends App{

  // Sets
  val set = Set(1,2,3,4,1,3,5)
  println(set)

  val sortedSet = TreeSet(1,2,3,4,1,3,5)
  println(sortedSet)

  // Mutable Set
  val mutableSet = scala.collection.mutable.Set.empty[String]
  val longString ="this is a long long line. it will repeat itself. this is how it is."
  val wordList = longString.split("[. ]")
  println(wordList.foreach(print))
  wordList.foreach(word => {mutableSet += word})
  println(mutableSet)

  //immutable Set methods
  val aSet = Set(1,2,3)
  println(aSet+5)  // 1,2,3,5
  println(aSet-2) // 1,3
  println(aSet++ Set(11,12,14)) // 1,2,3,11,12,14
  println(aSet-- Set(1,12)) //2,3
  println(aSet.size) //3
  println(aSet.contains(2)) //true

  //mutable Set methods
  val aSet2 = scala.collection.mutable.Set(1,2,3)
  println(aSet2+=5)  // 1,2,3,5
  println(aSet2-=2) // 1,3,5
  println(aSet2++= Set(11,12,14)) // 1,3,5,11,12,14
  println(aSet2--=Set(1,12)) //3,5,11,14
  println(aSet2.size) //4
  println(aSet2.contains(2)) //false

  // Maps
  val aMap = Map(1->"one",2->"Two",3->"three")
  for ((k,v) <- aMap)
    println(s"$k: $v")

  // immutable Map methods
  println(aMap+(5->"five"))
  println(aMap-2)
  println(aMap++ Map(11->"Eleven",12->"Twelve",14->"Fourteen"))
  println(aMap-- Set(1,12))
  println(aMap.size)
  println(aMap.contains(2))

}
