package com.akv.advance


object EX021_02_Implicit_parameters extends App{

  /*
  * implicit parameters extends the function call such as someFun(a) => someFun(a)(b)
  * or new someCall(a) => someClass(a)(b)
  * it will construct full last parameter list such as someFun(a) => someFun(a)(b,c,d)
  * The implicit parameter in function can be supplier explicitly also

   */

  class PreferredPrompt(val preference: String)

  object Greeter{

    def greet(name:String)(implicit prompt: PreferredPrompt){
      println(s"Welcome $name ,  the system is ready")
      println(prompt.preference)
    }
  }

  val myPrompt = new PreferredPrompt(">>>")
  Greeter.greet("Amit")(myPrompt)

  // in order to supply prompt parameter implicitly, let us define

  implicit val myPrompt2 = new PreferredPrompt("Hello Master>")
  Greeter.greet("Shubh")

  // eg. 2: Multiple implicit parameters
  class PreferredDrink(val drink:String)

  object Greeter2{
    def greet(name:String)(implicit promptPreference:PreferredPrompt,drinkPreference:PreferredDrink): Unit ={
      println(s"hi $name, welcome! \nyour preferred drink is: ${drinkPreference.drink}")
      println(s"your preferred prompt is: \n${promptPreference.preference}")
    }
  }

  implicit val drink = new PreferredDrink("Tea")
  Greeter2.greet("Prisha")

}

