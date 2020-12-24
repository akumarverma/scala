package com.akv.advance

object EX019_04_Parameter_Variance extends App{

  /*
   * if String < AnyRef then Set[String] < Set[AnyRef] === covariant
   * By default, Scala generic types are non-variant, it means
   * if String < AnyRef it does not means Set[String] is not subtype of Set[AnyRef]
   * we can demand covariant by using +T eg. MyQueue[+T]
   * similarly contravariant can be achieved by using -T eg. MyQueue[-T]
   * Scala compiler will check the soundness of covariant or contravariant
   * Normally mutating data causes issue in covariant
   * even immutable methods can also cause issue such as using math.sqrt() etc.
   * All soon as generic type appear in assignment or method parameter, covariant will not hold good


   */

  // eg. 1
  def willCompile(xs:Set[AnyVal]) = {xs}

  println(willCompile(Set(1,2,3)))        // Passing Int
  println(willCompile(Set(1L,2L,3L)))     // Passing Long
  println(willCompile(Set(1.2,2.4,3.6)))  // passing Double

  // eg. 2
  class Cell[T](init:T){
    private var current:T = init
    def get() = current
    def set(x:T) = (current =x)
  }

  val c = new Cell[Int](1)
  println(c.get())
  c.set(5)
  println(c.get())

  val c1 = new Cell[String]("abc")
  println(c1.get())
  // val c2:Cell[Any] = c1
  // above Will not compile since required is Cell[Any] and Supplied is Cell[String]
  // class Cell is non-variant

  // eg. 3
  /* below will not compile due to issue 1 and 2
  class Cell2[+T](init:T){
    private var current:T = init   // issue 1: Assignment
    def get() = current
    def set(x:T) = (current =x)    // Issue 2: Method parameter
  }
   */

}
