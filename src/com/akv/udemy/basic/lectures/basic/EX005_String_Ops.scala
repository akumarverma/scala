package com.akv.udemy.basic.lectures.basic

object EX005_String_Ops extends App{

  val aString:String = "Hello i am learning scala"

  println(aString.charAt(2))
  println(aString.substring(7,11))
  println(aString.toLowerCase())
  println(aString.length)
  println(aString.take(8))
  println(aString.drop(2))
  println(aString.split(" ").toList)
  println(aString.replace(" ","-"))

  //s-interpolation
  val name= "Shubh"
  val age=12
  println(s"My Name is $name and i am turning $age")

  //f-interpolation
  val pi =3.1414
  println(f"value of pi is $pi%1.5f")

  //raw-interpolation
  val longLine ="this is a long string\n spanning to multiple lines."
  println(raw"value of pi is $longLine")


}
