package com.akv.advance

object EX020_05_Abstract_Types extends App {


  class Food
  abstract class Animal {
    type SuitableFood <: Food
    def eat(food:SuitableFood):Unit
  }

  //eg. 1: cow and grass
  class Grass extends Food
  class Cow extends Animal {
    override type SuitableFood = Grass
    override def eat(food: SuitableFood): Unit = {
      println(s"$getClass eats $food")
    }
  }

  val lolli = new Cow()
  val grass = new Grass()
  println(lolli.eat(grass))

  class Fish extends Food
  val fish = new Fish()
  //println(lolli.eat(fish)) // Cows can't eat fish

  // eg.2 Dog, DogFood,CowFood
  class DogFood extends Food
  class Dog extends Animal{
    override type SuitableFood = DogFood

    override def eat(food: SuitableFood): Unit = println(s"$getClass eats $food")
  }

  val basky = new Dog()
  basky.eat(new DogFood)

  //basky.eat(new lolli.SuitableFood) // will not compile

  // eg 3: Dog eating dogfood
  val pammy = new Dog()

  basky.eat(new pammy.SuitableFood)  // path-dependent Type

  // eg. 4: path dependent type
  class Outer {
    class Inner
  }

  val o1 = new Outer
  val o2 = new Outer
  val i1 = new o1.Inner  // path-dependent Type
  println(i1.getClass)
  val i2 = new o2.Inner  // path-dependent Type
  println(i2.getClass)

  /*
  * Scala inner class hold a reference of outer class so that they can access outer class members
  * Accessing inner class require a reference of outer class eg, o1 or o2
  * to create an instance of inner class use o1.inner or o2.inner
  * we can't use new Outer#Inner since Outer doesn't name an instance of Outer
   */

}
