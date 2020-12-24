package com.akv.playground

import scala.util.Try

object Options extends App{

  val x:Any ="Amit"

  val res = Try(x.toString.toInt).toOption match {
    case Some(a) => "an Integer"
    case _ => "??"
  }

  println(res)



  }
