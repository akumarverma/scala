package com.akv.advance

object EX024_09_Iterators extends App {
  /*
  * Iterators are not collections, but a way to access a collection element one by one
  * jas methods next() and hasNext()
  * iterators next() moves the cursor to next. this is different from collections.
  * iterator and iterable both implement iterableOnce
  * bufferedIterator can look ahead without moving the cursor
  * method head -> look forward but not to move cursor
   */

  val iter = Iterator(1,2,3)
  while(iter.hasNext){
    print(iter.next())
  }
  println()

  val iter2 = Iterator("this","is","a","word")
  val iter3 = iter2.map(_.length)
  println(iter2.hasNext)   // map operation has not changed the cursor of iter2, it still returns true
  while(iter3.hasNext){
    print(iter3.next())
  }
  println()
  println(iter2.hasNext)  // it changes to false now(please note it is iter2)
  println(iter3.hasNext)

  // buffered iterator
  val it = Iterator(1,2,3,4,5)
  val bit = it.buffered
  println(bit.head)    // 1, cursor not moved forward
  println(bit.next())  // 1, cursor moved forward
  println(bit.next())  // 2, cursor moved forward


  // removing empty spaces from the start
  val aLongString = "   a long string with empty space at start"
  val strIterator:Iterator[String] = aLongString.split("[ ]").iterator
  println(strIterator)
  //a faulty implementation which misses words
  while(strIterator.hasNext){
    if (!strIterator.next.isEmpty)
      print(strIterator.next())
  }
  // a correct implementation using bufferedIterator

  val bufferedStrIterator = strIterator.buffered
  println(bufferedStrIterator)
  while(bufferedStrIterator.hasNext){
    if (!bufferedStrIterator.head.isEmpty) {
      print(bufferedStrIterator.next()+" ")
    }
    else{
      bufferedStrIterator.next()
    }
  }

}
