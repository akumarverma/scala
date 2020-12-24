package com.akv.advance

object EX024_08_Views extends App{

  /*
  * Collection in scala are either strict or non-strict(lazy).
  * Normally all collections are
  * strict except LazyList.
  * a collection will be converted to Lazy collection using view operator such as
  * List(1,2,3).view
  * A lazy collection will be converted back to normal using to operation
  * Use case:
  * 1.lazy collection is to find some element in a huge collection. for example
  * find "amit" in 1st One million words in Book
  * 2. Remove intermediate collection
   */

  // eg.1
  val vector = Vector(1,2,3,4,6)

  val newVector = vector.map(_+1).map(_*2)
  println(newVector)
  // above create intermediate collections

  val newLazyVector = vector.view.map(_+1).map(_*2)
  println(newLazyVector) // now computed yet, Type is IndexedSeqView

  println(newLazyVector.toVector)  // evaluated now, no intermediate data structure needed

  // eg. 2: find a number in first 1000 elements in 1000000 elements
  val aRange = 1 to 1000000
  println(aRange)

  println(aRange.take(1000).find(_==3))
  // aRange.take(1000) creates a list of 1000 element but 3 is only at thrid element

  val a1000View = aRange.view.take(1000)
  println(a1000View)
  println(a1000View.find(_==3))
  // don't creates a intermediate collection but evaluate at runtime


}
