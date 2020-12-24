package com.akv.advance

object EX030_Steps_for_Equals_Method extends App {

  /*
  * 1. Define canEquals: checks that the argument object is instance of current class
  * canEquals call should take this as argument
  * in equals method ensure that argument type os Any
  * use match in body of equals method
  * case should be : case that:<type> , <Type> should be the class defining equals
  * Inside matched case body invoke superclass.equals, canEquals etc
  * use a wildcard case _ returning false
  * if the equals method use super.equals(that), then hashCode should also invoke super Hashcode such as
  * override def hashCode():Int = (super.hashCode(),a,b)
  * use val instead of def in hashCode calculation to avoid performance issue
  * def will be evaluated each time when invoked whereas val will be calculated once when the object is
  * initialized


   */

}
