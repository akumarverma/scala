package com.akv.advance

import com.akv.advance.EX030_02_Equivalence_Relation.Color


object EX030_04_canEqual extends App{

  class Point(val x:Int,val y:Int){
    override def equals(obj: Any): Boolean = obj match {
      case a:Point => (a.x==this.x) && (a.y== this.y) && (a.canEqual(this))
      case _ => false
    }

    override def hashCode(): Int = (x,y).##

    override def toString: String = (x,y).toString()

    def canEqual(other:Any):Boolean = other.isInstanceOf[Point]
  }

  val p1,p2 = new Point(1,2)
  println(p1.equals(p2))

  val p3 = new Point(1,1) { override val y=2}

  println(s" $p1 ${p1.getClass}")    // Point class
  println(s" $p3 ${p3.getClass}")   // Anonymous class

  println(p1.equals(p3)) // finally true

  class ColoredPoint( x:Int, y:Int,val color:Color.Value) extends Point(x,y){

    override def equals(obj: Any): Boolean = obj match{
      case a : ColoredPoint => ((a.x == this.x) && (a.y == this.y) &&(a.color == this.color)
        && a.canEqual(this))

      case _ => false
    }

    override def canEqual(other: Any): Boolean = other.isInstanceOf[ColoredPoint]
  }

  val cpRed = new ColoredPoint(1,2,Color.red)
  val cpBlue = new ColoredPoint(1,2,Color.blue)

  println("Final Results")
  println(p1.equals(cpRed))  // false
  println(cpRed.equals(p1))  // false

}
