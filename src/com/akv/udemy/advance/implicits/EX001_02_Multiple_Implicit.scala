package com.akv.udemy.advance.implicits
/*
Multiple ordering for Person class based on name and age
 */

object EX001_02_Multiple_Implicit extends App{

  case class Person(name:String,age:Int)

  val persons = List(Person("Amit",42),Person("Swati",38),Person("Shubh",11),Person("Prisha",1))

  object sortPersonByName {

    implicit def sortByName: Ordering[Person] = Ordering.fromLessThan((a,b) =>{
      a.name.compareTo(b.name)>0
    })

  }

  //import sortPersonByName.sortByName  // if sorting is needed by name, enable this
  //println(persons.sorted)

  object sortPersonByAge {

    implicit def sortByAge: Ordering[Person] = Ordering.fromLessThan((a,b) =>{
      a.age > b.age
    })

  }

  import sortPersonByAge.sortByAge   // if sorting is needed by age, enable this
  println(persons.sorted)

  //ex. 2: Multiple ordering
  /*
  * Total Price 70%
  * unit Price 20
  * qty 10%
   */
  case class Purchases(qty:Int, price:Double)

  object Purchases{
    implicit def totalPriceOrdering:Ordering[Purchases]= Ordering.fromLessThan((a,b)=>{
      (a.price*a.qty)<(b.price*b.qty)
    })
  }

  object UnitPriceImplicit{
    implicit def unitPriceOrdering:Ordering[Purchases]= Ordering.fromLessThan((a,b)=>{
      (a.price)<(b.price)
    })
  }

  //implicit def qtyOrdering:Ordering[Purchases]= Ordering.fromLessThan((a,b)=>(a.qty)<(b.qty))

  val purchases = List(Purchases(5,42.5),Purchases(7,38.15),Purchases(3,11.35),Purchases(8,11.35))

  println(purchases.sorted)




}
