package com.akv.basic

object EX007_04_Math_Table_Function extends App{

  // Approach 1
  def multiplicationTable(): Unit ={
    var i=1
    while(i <= 10){
      var j=1
      while (j <= 20){

        val prod = (i*j).toString

        print(" "*(5-prod.length) + prod)
        j+=1
      }
      println()
      i+=1
    }
  }

  multiplicationTable()
  println("\n\n\n")

  // Approach 2
  def rowSeq(row: Int): Seq[String] = {
    for (col <- 1 to 20) yield {
      val prod = (row * col).toString()
      " " * (4 - prod.length) + prod
    }
  }
  def multiplicationTable2(): Unit = {
    for (row <- 1 to 10)
      println(rowSeq(row).mkString(" "))
  }
    multiplicationTable2()

}
