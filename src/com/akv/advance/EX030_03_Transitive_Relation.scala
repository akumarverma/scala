package com.akv.advance

import com.akv.advance.EX030_02_Equivalence_Relation.{Color, ColoredPoint, Point}

object EX030_03_Transitive_Relation extends App{

  class Point(val x:Int,val y:Int){
    override def equals(obj: Any): Boolean = obj match {
      case a:Point => (a.x==this.x) && (a.y== this.y) && (this.getClass== a.getClass)
      case _ => false
    }

    override def hashCode(): Int = (x,y).##

    override def toString: String = (x,y).toString()
  }

  class ColoredPoint( x:Int, y:Int,val color:Color.Value) extends Point(x,y){

    override def equals(obj: Any): Boolean = obj match{
      case a : ColoredPoint => ((a.x == this.x) && (a.y == this.y) &&(a.color == this.color)
        && (a.getClass == this.getClass))

      case _ => false
    }
  }

  val p = new Point(1,2)
  val cp = new ColoredPoint(1,2,Color.red)

  println(p.equals(cp))  // false

  println(cp.equals(p))  // false

  // both are false.. it is ok now since we are doing strict type checking
  // but consider below

  val pDummy = new Point(1,1) { override val y=2}
  println(s" $p ${p.getClass}")             // Point class
  println(s" $pDummy ${pDummy.getClass}")   // Anonymous class

  println(p.equals(pDummy)) // false since classes are different

  // Solution -> use canEqual method
  // define can Equal method in addition to equals and hasCode
  // def canEqual(Other:Any):Boolean
  // it is called from equals method... next exercise

}
