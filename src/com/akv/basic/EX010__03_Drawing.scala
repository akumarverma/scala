package com.akv.basic

object EX010__03_Drawing extends App{

  // Abstract class using height and width methods
  abstract class Element(){
    def contents(): Array[String]
    def height:Int = contents().length
    def width:Int = if (height==0) 0 else contents().length
    override def toString: String = s"ArrayElement: $width $height"
  }

  // Note:

  // defining subclass with parametric parameter
  class ArrayElement(override val contents: Array[String]) extends Element

  val elem:Element = new ArrayElement(Array("hello","world"))
  println(s"elm width and height are: ${elem.width} ${elem.height}")

  class LineElement(s:Array[String]) extends ArrayElement(s){
    override def width: Int = s.length
    override def height: Int = s.length

  }

  val lineElement:Element = new LineElement(Array("hello","world"))
  println(s"lineElement width and height are: ${lineElement.width} ${lineElement.height}")

}
