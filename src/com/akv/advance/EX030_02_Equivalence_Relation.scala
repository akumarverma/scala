package com.akv.advance

object EX030_02_Equivalence_Relation extends App {

  /*
  the equals in Any has below property, for all non-null values
  reflexive: x.equals(x)
  symmetric: x.equals(y) => y.equals(x)
  transitive: x.equals(y) and y.equals(z) => x.equals(z)
  consistent: x.equals(y) => always return true or false
  null, x.equals(null) => false
   */

  class Point(val x:Int,val y:Int){
    override def equals(obj: Any): Boolean = obj match {
      case a:Point => (a.x==this.x) && (a.y== this.y)
      case _ => false
    }

    override def hashCode(): Int = (x,y).##
  }

  val p1, p2 = new Point(1,2)

  println(p1.equals(p2))

  // so far so good, extending Point class with color enumeration

  object Color extends Enumeration {
    val red,orange,purple,yellow,blue = Value
  }

  class ColoredPoint( x:Int, y:Int,val color:Color.Value) extends Point(x,y){

    override def equals(obj: Any): Boolean = obj match{
      case a : ColoredPoint => (a.x == this.x) && (a.y == this.y) &&(a.color == this.color)
      case _ => false
    }
  }

  val cp1 = new ColoredPoint(1,2,Color.red)
  println("Working on ColoredPoint:")
  println(p1.equals(cp1))  // True

  println(cp1.equals(p1))  // false

  // The symmetric relationship is failed, let us reimplement ColoredPoint Class equal method

  class ColoredPoint2( x:Int, y:Int,val color:Color.Value) extends Point(x,y){

    override def equals(obj: Any): Boolean = obj match{
      case a : ColoredPoint2 => (a.x == this.x) && (a.y == this.y) &&(a.color == this.color)
      case a: Point => (a.x == this.x) && (a.y == this.y)
      case _ => false
    }
  }

  val cp2 = new ColoredPoint2(1,2,Color.red)
  println("Working on ColoredPoint2:")
  println(p1.equals(cp2)) // True
  println(cp2.equals(p1)) // True

  // Now the symmetric relation is satisfied, what about transitive relation?

  val redCp = new ColoredPoint(1,2,Color.red)
  val blueCp = new ColoredPoint(1,2,Color.blue)

  println(p1.equals(redCp))     // True
  println(p1.equals(blueCp))    // True
  println(redCp.equals(blueCp)) // false

  // above, the transitive relation has failed, p1 == redCp, P1 == blueCp, but redCp != blueCp
  // let us redefine Point and ColoredPoint once again in next lesson in more stricter way to match
  // the runtime class also.







}
