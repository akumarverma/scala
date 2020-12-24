package com.akv.udemy.advance.implicits

import java.util.Date

object EX001_03_Type_Class extends App{
  /*
  * Type class is a trait of type T define a set of operations applied on type T
  * Can define concrete class/object of many types by extending Type Class
  * such as UserSerializer or DateSerializer
  * Type class Template:
  * trait MyTypeClass[T] {
  *   def action(val: T): U
  * }
   */

  trait HTMLSerializer[T] {
    def serialize(arg:T):String
  }

  case class User(name:String,age:Int,email:String)

  object UserSerializer extends HTMLSerializer[User]{
    override def serialize(user: User): String =
      s"""
         |<html>
         |  <body>
         |    <div>
         |      <p>${user.name}</p>
         |      <p>${user.age}</p>
         |      <a href= ${user.email}</p>
         |    </div>
         |  </body>
         |</html>
         |""".stripMargin
  }

  val amit = User("Amit",42,"amit@gmial.com")

  println(UserSerializer.serialize(amit))

  object DateSerializer extends HTMLSerializer[Date] {
    override def serialize(arg: Date): String = s"<date>${arg.toString}</date>"
  }

  println(DateSerializer.serialize(new Date(2020,8,16)))

  object PartialUserSerializer extends HTMLSerializer[User]{
    override def serialize(arg: User): String = s"<name>${arg.name}</name>"
  }

  println(PartialUserSerializer.serialize(amit))

  // eg.3: Equal type class
  trait Equal[T]{
    def equal(a:T,b:T): Boolean
  }

  object User extends Equal[User]{

    override def equal(a: User, b: User): Boolean =
      (a.age==b.age) && (a.name== b.name) && (a.email==b.email)

  }

  val amit2 = User("Amit",42,"amit@gmial.com")

  println(User.equal(amit,amit2))


}
