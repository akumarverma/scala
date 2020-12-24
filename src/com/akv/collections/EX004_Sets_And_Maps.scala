package com.akv.collections

import scala.collection.immutable.TreeSet

object EX004_Sets_And_Maps extends App {
  /*
  * Scala has mutable and immutable version of sets and maps, default is immutable
  * Maps are similar to Array except element are accessed using key instead of index
  * use to operator to convert from immutable to mutable and vice versa
   */

  // eg.1 : Getting unique words from sentence
  val text = "See Spot run. Run, Spot. Run!"

  val textArray = text.split("[ !,.]+").toList
  println(textArray)

  var textSet = scala.collection.mutable.Set[String]()
  for (text <- textArray) textSet+=text
  println(textSet)

  // eg. 2: Sets method (immutable)

  val nums = Set(1,2,3)

  println(nums+4)
  println(nums-2)
  println(nums++ List(4,5))
  println(nums-- List(1,3))
  println(nums.contains(3))
  println(nums.size)

  // eg. 3: Set method (Mutable)

  val mSet = scala.collection.mutable.Set(1,2,3,4)

  mSet+= 5
  mSet-= 3
  mSet ++= List(11,12)
  mSet --= List(2,3)
  println(mSet)
  mSet.clear()
  println(mSet)

  // eg. 4: Maps

  val aMap = Map(1->"one",2->"two",3->"three")
  println(aMap + (4->"four"))
  println(aMap + (5->"five"))
  println(aMap - 2)
  println(aMap ++ List((6->"sixf"),(7->"seven")))
  println(aMap -- List(1,2))
  println(s"${aMap.size} ${aMap.contains(1)} ${aMap.keys} ${aMap.keySet} ${aMap.values} ${aMap.isEmpty}")

  // eg. 5: Immutable methods
  val mMap = scala.collection.mutable.Map(1->"one",2->"two",3->"three")

  mMap += (4->"four")
  mMap -= (1)
  mMap ++= List(7->"seven",8->"eight")
  mMap --= List(1,2)
  println(mMap)

  // eg.6 : sorted Set and Map
  val ts = scala.collection.immutable.TreeSet(3,5,1,9,-5,2,11)
  println(ts)

  val tm = scala.collection.immutable.TreeMap(6->"Six",1->"One",3->"Three",2->"two")
  println(tm)

  // eg. 7: Updating immutable set/map

  var is = Set(1,4,2,6,3)

  is += 5 // is is immutable, but defined as var so it allows += operation
  // is+= 5 is equivalent to is = is+5, the new set will be reassiged back to is

  println(is)

  is ++= List(11,12,15)

  println(is)

  var im = Map(1->"one",2->"two",3->"three")

  im += (4->"four")

  println(im)

  // eg. 8: Collection type

  var as = Set(1,2,3) // as is Set[Int]

  var as2= Set[Any](1,2,3) // as is Set[Any]

  as2 += "Amit"

  println(as2)

  // eg. 9: sorting a Collection

  val intList = List(4,2,9,6,1,10)

  val sortedList = intList.to(TreeSet).toList

  println(sortedList)

  // eg. 10: converting between immutable to mutable and vice versa

  val mutSet = scala.collection.mutable.Set(1,2,3)

  val immSet = mutSet.to(Set)
  println(immSet)

  val mutSet2 = immSet.to(scala.collection.mutable.Set)
  println(mutSet2)

  val mutMap = scala.collection.mutable.Map(1->"one",2->"two")

  val immMap = mutMap.to(Map)
  println(immMap)

  val mutMap2 = immMap.to(scala.collection.mutable.Map)
  println(mutMap2)








}
