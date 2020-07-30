package com.akv.udemy.basic.lectures.oop
import scala.language.postfixOps

object EX007_infix_prefix_postfix extends App{

  class Person(val name:String, favoriteMovie:String,val age:Int=0) {
    def likes(movie:String) = (movie == favoriteMovie)
    def + (another: Person):String = s"${this.name} and ${another.name} likes $favoriteMovie"
    def + (nickname: String):Person = new Person(s"$name ($nickname)",favoriteMovie)
    def unary_! :String =s"${this.name} doesn't like $favoriteMovie"
    def unary_+ :String= s"${this.name} is turning ${age+1}"

    def alive:Boolean = true
    private def learns(lang:String):String = s"$name learns $lang"

    def leansScala(): String = learns("scala")

    def apply(cnt:Int):String = s"$name has seen $favoriteMovie $cnt times"

    override def toString: String = s"$name likes $favoriteMovie"

  }

  val amit = new Person("Amit","The Last king of Scotland")
  val swati = new Person("Swati","Inception")

  // Infix
  println(amit likes "Inception")
  println(amit.likes("Inception"))
  println(amit + swati)
  println((amit + "pinku").toString)

  //prefix
  println(!amit)
  println(!amit)
  val shubh = new Person("Shubh","Angry Bird",10)
  println(+shubh)

  //postfix
  println(amit.alive)
  println(amit alive)
  println(amit leansScala)

  // apply method
  println(amit.apply(2))
  println(amit(2))


}
