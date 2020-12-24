package com.akv.advance

object EX030_05_Equality_Parametrized_Types extends App{

  trait Tree[+T]{
    def elem: T
    def left: Tree[T]
    def right: Tree[T]
  }

  object emptyTree extends Tree[Nothing]{
    def elem:Nothing = throw new NoSuchElementException("emptyTree.elem")
    def left:Tree[Nothing]= throw new NoSuchElementException("emptyTree.left")
    def right:Tree[Nothing]= throw new NoSuchElementException("emptyTree.right")
  }

  class Branch[+T] (val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T]{
    override def equals(obj: Any): Boolean = obj match{
      case that:Branch[_]=> (( that canEqual this) && (this.elem == that.elem) &&
        (that.left == this.left) &&
        (that.right == this.right))
      case _ => false
    }

    override def hashCode(): Int = (elem,left,right).##

    def canEqual(other:Any):Boolean = other match {
      case that: Branch[_] => true
      case _ => false
    }


    /*
    *     def canEqual(other:Any):Boolean = other.isInstanceOf[Branch[_]]
     */

  }

  val b1 = new Branch[List[String]](Nil,emptyTree,emptyTree)

  val b2 = new Branch[List[String]](Nil,emptyTree,emptyTree)

  println(b1.equals(b2))

  /*
  * case that: Branch[t]  --> small case t represent unknown type
  * it can also be replaced with _ such as case that: Branch[_]
   */

}
