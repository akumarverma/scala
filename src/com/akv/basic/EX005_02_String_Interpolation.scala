package com.akv.basic

object EX005_02_String_Interpolation extends App{

  val name = "Amit"
  val age = 15
  val address = "ZYZ,Finland"
  val purchases = 15.4569f

  println(s"$name Aged $age staying in \n $address made a purchase of $purchases")

  println(raw"$name Aged $age staying in \n $address made a purchase of $purchases")

  println(f"$name Aged $age staying in \n $address made a purchase of ${purchases}%.2f")

}
