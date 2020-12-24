package com.akv.udemy.advance.implicits

object EX001_04_Type_Class_And_Implicit extends App{

  trait HTMLSerializer[T] {
    def serialize(arg:T):String
  }

  object HTMLSerializer{
    def serialize[T](value:T)(implicit serializer:HTMLSerializer[T]):String =
      serializer.serialize(value)

    def apply[T](implicit serializer:HTMLSerializer[T])= serializer
  }

  implicit object intSerializer extends HTMLSerializer[Int]{
    override def serialize(arg: Int): String = s"<div>$arg</div>"

  }

  println(HTMLSerializer.serialize(42))
  println(HTMLSerializer[Int].serialize(42)) // exposes all method of Type class

  // eg.2: Equal type class

  case class User(name:String,age:Int,email:String)

  val amit = User("Amit",42,"a@gmail.com")
  val anotherAmit = User("Amit",42,"a@gmail.com")

  trait Equalizer[T]{
    def equal(a:T,b:T):Boolean
  }

  implicit object UserEqualizer extends Equalizer[User]{
    override def equal(a: User, b: User): Boolean = a.name ==b.name
  }

  object FullUserEqualizer extends Equalizer[User]{
    override def equal(a: User, b: User): Boolean = a.name ==b.name && a.age==b.age && a.email==b.email
  }

  implicit object intEqualizer extends Equalizer[Int]{
    override def equal(a: Int, b: Int): Boolean = a==b
  }

  object objEqual{
    def equal[T](a:T,b:T)(implicit equalizer:Equalizer[T]):Boolean = equalizer.equal(a,b)

    def apply[T](implicit equalizer:Equalizer[T]) = equalizer
  }

  // option 1 :passing equalizer explicitly
  println(objEqual.equal(4,2)(intEqualizer))

  println(objEqual.equal(amit,anotherAmit)(UserEqualizer))

  // option 2 :passing equalizer implicitly
  println(objEqual.equal(4,2))

  println(objEqual.equal(amit,anotherAmit))


  // option 3 :using apply method
  println(objEqual[Int].equal(4,2))

  println(objEqual[User].equal(amit,anotherAmit))




}
