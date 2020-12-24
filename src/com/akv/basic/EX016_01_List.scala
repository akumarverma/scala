package com.akv.basic

object EX016_01_List extends App{

  /*
  * Lists are similar to array but immutable
  * Lists are implemented as linked list whereas Arrays are flat
  * Lists are homogeneous
  * List are covariant, eg. List[String] is subtype of List[Object]
  * Empty list are of type List[Nothing]
  * Basic list operations are head, tail and isEmpty
  * All list are build using two fundamental construct nil, :: (cons)
   */

  val aList = List(1,2,3,4)
  val aList2:List[Int] = List(1,2,3,4)
  val aList3:List[Int] = List()  // list type in Scala is covariant so LIST[Nothing] is subtype of List[Int]

  val aList4 = 1::2::3::4::Nil
  val aList5 = 1::(2::(3::(4::Nil))) // :: called cons operator

  // sorting a List
  val unsortedList = List(4,6,1,3,5)

  // Approach 1 using if
  def sorted(xs:List[Int]):List[Int] ={
    if (xs.isEmpty) Nil
    else
      {
        println(xs.head)
        println(xs.tail)
        insert(xs.head,sorted(xs.tail))
      }

  }

  def insert(x:Int,xs:List[Int]): List[Int] ={
    if (xs.isEmpty) List(x)
    else if (xs.isEmpty || x<= xs.head) x:: xs
    else xs.head ::(insert(x,xs.tail))

  }
  println(sorted(unsortedList))

  // Approach 2  using pattern
  def sorted2(xs:List[Int]):List[Int] = xs match{
    case  List() => xs
    case x::xs1 =>
    {
      println(x)
      println(xs1)
      insert2(x,sorted(xs1))
    }

  }

  def insert2(x:Int,xs:List[Int]): List[Int] =xs match{
    case List() => List(x)
    case y::ys => if(x<= y) x:: xs
                  else y ::(insert(x,ys))

  }
  println(sorted2(unsortedList))

}
