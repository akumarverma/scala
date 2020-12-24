package com.akv.basic

object EX003_02_List extends App{

  /*
  * :: is right operand 1:: List(2,3) ==> List(2,3).::(1)
  * 1::2::3::Nil => 1::2::(Nil.::(3)) ==> 1::((Nil.::(3)).::(2)) ==> ((Nil.::(3)).::(2)).::(1)
  * List :: prepend to list, +: append the element to List, but it is saldomly used since it require
  * fill list traversal
  * Options for append are: prepend elements and then reverse
  * Use ListBuffer/ Mutable List and finally use toList method
   */

  // List are immutable
  val list1 = List(1,2)
  val list2 = List(2,3)
  // List concatenation
  val list3 = list1 ::: list2
  print(list1+ " " + list2 + " "+ list3)
  println()
  // List prepend(NOT APPEND) :: "Cons" operator works right to left
  val list4 = 1 :: list2
  print(list4)
  println()
  // List creation using "Cons" operator
  val list5 = 1::2::3::Nil
  print(list5)
  println()

  val list6 = List(10,11).::(12)
  print(list6)
  println()
  // Note: List don't have append method

  // List methods
  val myList = List(1,2,3,4,5)
  println(myList.head) //1
  println(myList.last) //5
  println(myList.tail) //2,3,4,5
  println(myList.init) //1,2,3,4
  println(myList.filter(x=> x>2)) //3,4,5
  println(myList.drop(3)) //4,5
  println(myList.dropRight(3)) //1,2
  println(myList.map(x=> x*2)) //double numbers
  println(myList.reverse) //5,4,3,2,1
  println(myList.count(_%2==0)) //2
  println(myList.forall(_>0)) // true
  println(myList.exists(_<0)) // false
  myList.foreach(print)



}
