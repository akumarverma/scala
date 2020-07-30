package com.akv.udemy.basic.lectures.basic

object EX004_Call_By_value_and_name extends App{

  def aCallByValue(x:Long): Unit ={
    println("current time is "+x)
    println("current time is "+x)
  }

  def aCallByName(x: => Long): Unit ={
    println("current time is "+x)
    println("current time is "+x)
  }

  aCallByValue(System.nanoTime())  // system.nonoTime() is evaluated while invoking the function
  aCallByName(System.nanoTime())   // system.nonoTime() is evaluated at runtime inside invoked function

  def anInfinite: Int = 1+anInfinite

  def aCallByName(a:Int, b: => Int): Unit = println("value of a is:"+a)

  aCallByName(1,anInfinite) // it will run fine

  // aCallByName(anInfinite,1) // it will fail

}
