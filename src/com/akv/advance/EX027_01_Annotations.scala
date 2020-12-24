package com.akv.advance

object EX027_01_Annotations extends App{
  /*
  * Annotation can be used with variables,methods,expressions etc.
  * @deprecated  -- methods, class are not supported in future
  * @volatile - mutable objects will be used in concurrent programming
  * @tailrec - add this annotation to the methods supposed to be tail recursive
  * @unchecked - tells compiler not to worry about missing cases
  */

  // Eg.1 : deprecated
  @deprecated("Use method b instead")
  def a() ={"This is deprecated"}
  def b() ={}
  println(a)


}
