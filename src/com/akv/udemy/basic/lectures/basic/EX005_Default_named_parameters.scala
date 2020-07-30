package com.akv.udemy.basic.lectures.basic

object EX005_Default_named_parameters extends App{

  //Example 1
  def factorial(n:Int, accumulator:BigInt=1): BigInt ={
    if (n==1) accumulator
    else factorial(n-1,n*accumulator)
  }

  val factVal = factorial(5)
  println(factVal)

  //Example 2
  def showImage(imgType:String="jpg",width:Int=1200,height:Int=1720): String ={
    s"Showing image of type $imgType having width $width and height $height"
  }

  println(showImage())
  println(showImage(height = 1200,width = 1680))
  println(showImage(imgType = "tiff",width = 600))
  println(showImage("bmp",400,1680))

}
