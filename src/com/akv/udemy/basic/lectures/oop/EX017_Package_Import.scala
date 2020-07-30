package com.akv.udemy.basic.lectures.oop

import com.akv.udemy.basic.lectures.oop.EX008_Objects.Person

import java.sql.{Date=> SqlDate} // import package alias


object EX017_Package_Import extends App{

  val date = new java.util.Date(2020,11,31) //fully qualified name

  val person = new Person("Amit") // using import from another file

  val sqlDate = new SqlDate(2020,11,25)

  val pi = PI  // importing from package object

  println(pi.toString)


}
