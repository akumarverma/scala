package com.akv.advance


object EX026_01_Extractors extends App{
  /*
  * Object with unApply method called extractor
  * apply -> Injection, unapply-> Extraction
  * Most Collections implements unapplySeq
   */

  object Email{

    def apply(user:String,domain:String):String = user+"@"+domain

    def unapply(email:String):Option[(String,String)] ={
      val emailComponents = email.split("@")
      if (emailComponents.length ==2) Some(emailComponents(0),emailComponents(1))
      else None
    }
  }

  val myEmailExtraction = Email.unapply("AKV@gmail.com")
  println(myEmailExtraction)

  val email = "akv@gmail.com"
  val patMatching = email match {
    case Email(u,d) => (u,d)
    case _ =>
  }

  println(patMatching)

  //eg. 2 Varying Number of extractor, unapplySeq

  val d = List("hotmail","com")

  object Domain{
    def apply(s:String*):String = s.reverse.mkString(".")

    def unapplySeq(whole:String):Option[Seq[String]] = Some(whole.split("\\.").reverse.toSeq)
  }


  def domainMatch(x:String) = x match {
    case Email(user, Domain("com",_*)) => true
    case _ => false
  }

  println(domainMatch("akv@hotmail.com"))
  println(domainMatch("akv@hotmail.net"))
  println(domainMatch("akv@hotmail.in"))

  // eg. 3 returning some fixed and varying part from Extractor

  object ExtendedEmail{

    def unapplySeq(whole:String): Option[(String, Seq[String])] ={
      val parts = whole.split("@")
      println(parts(0))
      println(parts(1))
      println(parts.length)
      if (parts.length==2){
        Some(parts(0),parts(1).split("\\.").reverse.toSeq)
      }
      else None
    }
  }

  val longEmail = "akv@techm.outlook.com"
  val s = ExtendedEmail.unapplySeq(longEmail)
  println(s)




}

