package com.akv.basic
import scala.collection.{immutable,mutable}

object EX003_04_Set_And_Map extends App{
  // 1. Mutable set ( the same set will be operated upon)
  val mutableSet = mutable.Set(1,2,3,3)

  println(mutableSet)  // No duplicate

  mutableSet+=5

  println(mutableSet)  // Number 5 added to set

  // 2. Immutable set ( a new set will be created by performing operation on it)
  val immutableSet = immutable.Set(1,2,3,3)

  println(immutableSet)  // No duplicate

  val newImmutableSet = immutableSet+5 // immutable set can't be modified, + operation create a new Set

  println(immutableSet+ " "+ newImmutableSet )  // Number 5 added to set

  // Map Example
  var aMap =  immutable.Map[Int,Char]() // Note: mind var not val

  aMap+=(1->'a') // create a new Map and assign it to aMap
  aMap+=(2->'b') // create a new Map and assign it to aMap

  println(aMap)

  val aMap2 =  mutable.HashMap[Int,Char](0->'-')

  aMap2+=(1->'a')
  aMap2+=(2->'b')


  println(aMap2)
  println(aMap2(2))


}
