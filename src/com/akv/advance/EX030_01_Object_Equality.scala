package com.akv.advance

object EX030_01_Object_Equality extends App{
  /*
  * java has two equality operators == and equals
  * for value types == is comparators same as java
  * for reference types, == is same as equals in scala
  * == can't be overridden(defined final in class Any) but equals can be
   */

  val x = "Amit"
  val y = "Amit"
  println(x==y)  // true in scala but false in Java

  /*
  * Most of time, equals is implemented faulty, which has great impact on collection implementation
  * common pitfalls are:
  * defining equals with wrong signature, changing equals without changing hashcode,defining equals in terms
  * of mutable objects and failing defining equals as equivalent methods.
   */

  // pitfall 1: Defining equals with wrong signature

  class Point(val x:Int,val y:Int) {
    def equals(obj: Point): Boolean = ((this.x == obj.x) && (this.y == obj.y)) // a wrong definition of equals

    override def equals(obj: Any): Boolean = super.equals(obj)
  }

  val p1,p2 = new Point(1,2)
  val q1 = new Point(2,3)
  println(p1 equals p2)
  println(p1 equals q1)
  // so far so good, the problem starts now

  val set = new scala.collection.mutable.HashSet[Point]()

  set += p1
  println(set.contains(p2)) // returns false .. Strange

  // The issue is in equals definition, it is taking Point as argument whereas the super taken Any
  // so the parent equals method was not overridden but actually overloaded

  // eg.2 - a better approach
  class Point2(val x:Int,val y:Int) {
    override def equals(obj: Any): Boolean = obj match{
      case a: Point2 => (this.x == a.x) && (this.y == a.y) // a better definition of equals
      case _ => false
    }

  }

  val p21, p22 = new Point2(1,2)

  val set2 = new scala.collection.mutable.HashSet[Point2]()

  set2 += p21

  println(set2.contains(p22)) // returns false .. again Strange. why?

  /* Point2 implement correct equals method and has not defined hashcode method
  * HashSet puts the element in hash buckets based on their hash code
  * if we have not overridden hasCode method, it will invoke super method and hence hashCode
  * for p21 and p22 is not same. since the hashcode is different it will be placed in different has buckets
   */

  // eg.3 - a better approach defining equals plus hasCode
  class Point3(val x:Int,val y:Int) {
    override def equals(obj: Any): Boolean = obj match{
      case a: Point3 => (this.x == a.x) && (this.y == a.y) // a better definition of equals
      case _ => false
    }

    override def hashCode(): Int = (x,y).##

  }

  val p31, p32 = new Point3(1,2)

  val set3 = new scala.collection.mutable.HashSet[Point3]()

  set3 += p31

  println(set3.contains(p32)) // finally true .. happy.. happy .. happy!!!

  // eg. 4 -- using mutable elements

  // eg.3 - a better approach defining equals plus hasCode
  class Point4(var x:Int,var y:Int) {
    override def equals(obj: Any): Boolean = obj match{
      case a: Point4 => (this.x == a.x) && (this.y == a.y) // a better definition of equals
      case _ => false
    }

    override def hashCode(): Int = (x,y).##

  }

  val p41 = new Point4(1,2)

  val set4 = new scala.collection.mutable.HashSet[Point4]()

  set4 += p41

  println(set4.contains(p41)) //  true .. so far so good

  p41.x +=1

  println(set4.contains(p41)) //  very very strange... now P41 is not showing in hastSet

  //The reason for this is, the new value of x has changed the hash code value and the original
  // hash bucket no longer correspond to new hast Code. so point p41 "dropped out of sight" in hash Set.

  println(set4.iterator.contains(p41)) // the element is still in set, but out of sight




}
