package com.akv.basic

object EX016_02_List_Methods extends App {

  // Section 1: First order methods(functions not taking function as argument)
  val list = List(1,2,3) ::: List(4,5,6) // ::: concatenation

  println(s"$list \nLength: ${list.length} " +
    s"\nInit: ${list.init} " +
    s"\nlast: ${list.last}" +
    s"\nhead: ${list.head}" +
    s"\ntail: ${list.tail}" +
    s"\nreverse: ${list.reverse}" +
    s"\nmkString: ${list.mkString("-")}"+
    s"\ntoString: ${list.toString}"+
    s"\nindices: ${list.indices}"
  )

  /*
   * List.length==0 and list.isEmpty both returns same result, but length function is expensive
   * since it has to traverse the list
   * init and last is also require list traversal
   */


  // take, drop, splitat
  println(list.drop(2)) //3,4,5,6
  println(list.take(3)) //1,2,3
  println(list.splitAt(3)) // List(1,2,3) & list(4,5,6)
  // splitAt combintes take and drop

  // flatten
  val listOfList = List(List(1,2),List(3,4),List(5,6))
  println(s"flatten List: ${listOfList.flatten}")

  val listOfString = List("Amit","Swati","Shubh","Prisha")

  println(listOfString.map(_.toCharArray).flatten)

  //zip and unzip
  val abcde =List('a','b','c','d','e')
  println(abcde.zip(list))
  val zipped = list.zip(abcde)
  println(zipped)

  val unZipped = list.zip(abcde).unzip
  println(unZipped)

  // Array to List and vice-verse

  val aArray: Array[Int] = Array[Int](11,12,13,14,15)
  println(aArray.toString)
  println(aArray.toList)
  println(list.toArray)

  // copying to Array
  val arrayToCopy = list.copyToArray(aArray,0)
  // using iterator for navigation
  val iter = aArray.iterator
  while(iter.hasNext)
    println(iter.next())

  // Section 2: higher-order functions

  // map, flatMap
  val incrementList1 = list.map(_+1)
  val incrementList2 = list.map(x=> x+1)
  println(incrementList1)
  println(incrementList2)
  val toCharList = listOfString.map(_.toList)
  println(toCharList)
  val flatCharList = listOfString.flatMap(_.toList)
  println(flatCharList)

  // foreach
  var sum =0
  list.foreach(x => {sum=x+sum})
  println(sum)
  sum =0
  list.foreach(sum+=_)
  println(sum)

  // filter, partition, find
  println("Filter partition and find")
  val filteredList = list.filter(_>4)
  println(filteredList)
  val partitionedList = list.partition(_%2==0)
  println(partitionedList)  // return 2 list one where predicate is true and one with false
  val findFour = list.find(_==4) // return some or None
  println(findFour)
  val findFourMatch = findFour match{
    case Some(x) => x
    case None => -1
  }
  println(findFourMatch)

  // takeWhile, dropWhile, Span
  val randomList = List(4,5,1,-4,2)
  println(randomList.takeWhile(_>0))  // 4,5,1
  println(randomList.dropWhile(_>0))  // -4,2
  println(randomList.span(_>0))  // 4,5,1 and -4,2
  //span === splitAt, creates two list

  // forall and exists
  println(randomList.forall(_>0))  // false
  println(randomList.exists(_>0))  // true

  //foldLeft, foldRight
  val aList = List(1,2,3,4,5)
  val aStringList = List("My","name","is","Amit","verma")
  println("Sum of List: " +aList.foldLeft(0)(_+_))
  println("Product of List: " +aList.foldRight(1)(_*_))
  println(aStringList.foldLeft("")(_+" "+_))

  // Sortwith
  println("Sorted List: "+List(9,4,-3,1,5).sortWith(_<_))
  println("Sorted String List: "+aStringList.sortWith(_.length<_.length))


  // List object(not Class) methods
  println(List.range(1,5))
  println(List.range(1,9,2))
  println(List.range(10,1,-3))

  // Fill method
  println(List.fill(5)("A"))
  println(List.fill(5,2)("A"))

  println(List.tabulate(5)(n=> n*n))
  println(List.tabulate(5,5)(_*_))

  // multiple operation on list
  val lazyMap = (List(10, 20) lazyZip List(3, 4, 5)).map(_ * _)
  println(lazyMap)

  val lazyMap2 = (List("Amit", "kumar","verma") lazyZip List(4,2, 5)).map(_.length== _)
  println(lazyMap2)

}
