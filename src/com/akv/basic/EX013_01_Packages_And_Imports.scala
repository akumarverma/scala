package com.akv.basic // the code is inside com.akv.basic package

object EX013_01_Packages_And_Imports extends App{

  val animal = new fi.st.Animal
  println(animal)   // om.akv.basic.fi.st.Animal

  /*
  * Class in same package can be referenced without package qualifier
  * Import allows member of a package available without qualifying its full name
  * import all package._ not package.*( different from Java)
  * Import in scala can appear anywhere
  * package can also be imported such as java.util.regex and use pattern as regex.pattern
  * package import can hide and rename the import
  * eg. com.akv.{Animal, Fruit} // only Animal and Fruit are imported
  * eg. com.akv.{Animal => MyAnimal, Fruit} // Animal is renamed as MyAnimal
  * eg. java.sql.{Date => SqlDate}
  * eg com.akv.Fruits{Pears => _,_) // import everything except Pears
  * eg. com.akv.Fruits._ is equivalent to com.akv.Fruits.{_}
  * eg. com.akv.Fruits.Apple is equivalent to com.akv.Fruits.{Apple}
  * java.lang, scala and predef are imported implicitly
  * In these 3 implicit imports, the later overshadowed previous
   */

}

// Another way of creating package
package fi {

  package st {
    class Animal
  }

}