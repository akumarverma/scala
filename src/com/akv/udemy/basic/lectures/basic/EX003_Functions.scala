package com.akv.udemy.basic.lectures.basic

object EX003_Functions extends App{

  def aFunc1(a:String, b:Int): String ={
    a+" "+b
  }
  println(aFunc1("Amit",42))

  def aRepeatFunction(str: String,n:Int):String ={
    if (n==1) str
    else
      str +" "+ aRepeatFunction(str,n-1)
  }

  println(aRepeatFunction("Hello",3))

  def aPrime(n:Int): Boolean ={
    def isPrime(n:Int,i:Int):Boolean ={
      if (i>n/2) true
      else if (n%i==0) false
      else isPrime(n,i+1)
    }
    isPrime(n,2)
  }

  val aList =List(3,4,7,11,15,17,21,25,30)
  aList.map(num => println(s"is $num a Prime Number: ${aPrime(num)}"))

  def aFactorialFunction(n:Int):Int ={
    if (n==1) 1
    else
      (n * aFactorialFunction(n-1))
  }
  println(aFactorialFunction(5))

  def anotherFactorial(n:Int):BigInt ={
    def factHelper(x:Int,factorial:BigInt):BigInt ={
      if (x== 1) factorial
      else {
        println(s"calculating value of x-1 is ${x-1} and x*factorial is ${x*factorial}")
        val z= factHelper(x-1,(x*factorial))
        println(s"Calculated value of x-1 is ${x-1} and x*factorial is ${x*factorial}")
        z
      }

    }

    factHelper(n,1)

  }
  println(anotherFactorial(5))

}
