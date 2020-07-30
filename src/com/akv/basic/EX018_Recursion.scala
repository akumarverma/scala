package com.akv.basic

object EX018_Recursion extends App {

  // Looping through a array to find a match and break the loop once found
  val aList = Array[String]("_.doc", "_a.txt","a.pdf")

  //Approach 1 without recursion
  var aFound = false
  var i=0
  while ((i < aList.length) && !(aFound)) {
    println(aList(i))
    if (aList(i).startsWith("_")) {
      if (aList(i).endsWith(".txt")) {
        aFound=true
        1
      }
    }
    i+=1
  }

  //Approach 2 with recursion
  def searchFile(i:Int): Int ={
    if (i>= aList.length) -1
    else if (!aList(i).startsWith("_")) searchFile(i+1)
    else if (aList.endsWith(".txt")) i
    i+1
  }

  println(searchFile(0))
}
