package com.akv.basic

object EX007_02_For_Loop extends App {
  /*
  * for loops are: foreach, for (arg <- args)
  * for expression can take if parameters
  * integer list (1 to 5) (i until 5)
  * for loop can ne nested
  * for loop can create another loop using yield
   */

  val aList = List('A', 'B', 'C', 'D', 'E')
  var i = 0
  // option 1
  while (i < aList.length) {
    println(aList(i))
    i = i + 1
  }

  // option 2.1
  aList.foreach(chr => {
    print(chr)
  })
  println()

  // option 2.2
  aList.foreach(chr => print(chr))
  println()

  // option 2.3
  aList.foreach((chr: Char) => print(chr))
  println()

  // option 2.4
  aList.foreach(print)
  println()

  // option 2.5
  aList.foreach(print(_))
  println()

  // option 3
  for (chr <- aList)
    print(chr)

  val files = (new java.io.File(".")).listFiles()

  for (file <- files) println(file.getName)

  val aArray = new Array[Int](3)
  aArray(0) = 0
  aArray(1) = 1
  aArray(2) = 2

  for (i <- 0 to 2)   // upperbound 2 is included
    print(aArray(i))
  println()

  for (i <- 0 until 2)   // upperbound is excluded
    print(aArray(i))
  println()

  case class Person(name: String, isMale: Boolean, children: Person*)

  val shubh = Person("Shubh", true)
  val prisha = Person("Prisha", false)
  val swati = Person("swati", false, prisha, shubh)
  val amit = Person("Amit", true, prisha, shubh)

  val persons = List(shubh, prisha, amit, swati)

  val personList = for {p <- persons;
                        if p.isMale;
                        c <- p.children} yield (p.name, c.name)
  println(personList)

  val personList2 = persons filter(p => !p.isMale) flatMap( p=> p.children.map(c => (p.name,c.name)))

  val personList3 = persons.filter(!_.children.isEmpty)

  println(personList3)


  class Demo{
    def map[A,B](xs:List[A],f:A =>B): List[B] ={
      for (x <-xs) yield f(x)
    }
    def map2[A,B](xs:List[A])(f:A =>B): List[B] ={
      for (x <-xs) yield f(x)
    }
  }

  def square(x:Int) = {println(x);x*x}

  val aDemoList =List(1,2,3)
  val aDemoResultList = List()
  val x = (new Demo).map2(aDemoList)((x:Int)=>x*x)
  println(x)


}
