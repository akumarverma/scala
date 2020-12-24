package com.akv.advance

object EX000_01_Advance_Notes {

  /* Chapter 18(Mutable Objects)
  * operation on mutable objects may result different value in different run
  * every non-private var in scala defines getter and setter.
  * def x:Int = x and def x_(a:Int):Unit = a
  * var a:Int =_ initialize a to 0, _ is initialization of default value(0,False, null etc) based on type
  * if we leave =_, the field became abstract
  * getter and setter of a field can derive value from other field also
  * eg, fahrenheit getter and setter can derive value from celsius

   */

  /* Chapter 19(Type Parameterization)
  * Type parametrization allows writing generic classes and traits
  * Sets,Lists, Maps etc are generic such as Set[Int], Set[String] etc
  * Variance defines inheritance relationship between generic types List[String] is subset of List[AnyRef]
  * private constructor instance can not be created, it can be accessed by companion object
  * class A private(val a:Int), we can't use val a = new A(5)
  * need to use companion object to access the constructor method
  *   object A { def apply(a:Int) = new A(a) }
  * val x = A(5)
  * a approach for information hiding is create a trait for specification, create a object to have
  * factory method and a inner class defining traits
  * Variance
  * =========
  *  if String < AnyRef then Set[String] < Set[AnyRef] === covariant
   * By default, Scala generic types are non-variant, it means
   * if String < AnyRef it does not means Set[String] is not subtype of Set[AnyRef]
   * we can demand covariant by using +T eg. MyQueue[+T]
   * similarly contravariant can be achieved by using -T eg. MyQueue[-T]
   * Scala compiler will check the soundness of covariant or contravariant
   * Normally mutating data causes issue in covariant
   * even immutable methods can also cause issue such as using math.sqrt() etc.
   * All soon as generic type appear in assignment or method parameter, covariant will not hold good
   * Type Class/Constructor are generic traits defining the features and can create multiple types
   * eg, MyQueue[T]{ def ... } can create multiple types such as MyQueue[Int],MyQueue[String] etc
   * Error: “covariant type T occurs in contravariant position in type T of value x”
   * Lower Bound: def enqueue[U >: T](x: U): List[U]
   * U is supertype of T and the resulting type is more generic than T
   * Contravariance/ Upper bound pending????

   */

  /* Chapter 20(Abstract Members)
  * scala allows fields, types, methods to be abstract in addition to methods
  * val initial:T = "Hi" is same as def initial:T = "Hi"
  * abstract def can either be implemented as val or def
  * but abstract val can not be defined as def
  * def -> val is fine, but val -> def will not compile
  * var x: Int is break into a getter and setter as def x():Int and def x_(x:Int):Unit
  * abstract initialization
  * =======================
  * class parameters are evaluated before object is initialized
  * whereas abstract vals are evaluated as part of initialization, it is initialized after
  * superclass constructor is invoked
  * so initializing a subclass extending a abstract class may fail, eg. a rational subclass
  * implementing a abstract super class in chapter 20 Abstract initialization
  * Scala solution: pre-initialized fields/Lazy vals
  *   object oneByTwo extends {val numerArg=1,val denomArg=2 } with RationalTrait
  * pre-initialized fields can't refer "this" since it is called before super initialization
  * Lazy Vals
  * =============
  * the vals with Lazy qualifier will be initialized when first referenced
  * Order of initialization doesn't matter, it depends how it is referenced
  * Abstract Types
  * ===============
  * Scala inner class hold a reference of outer class so that they can access outer class members
  * Accessing inner class require a reference of outer class eg, o1 or o2
  * to create an instance of inner class use o1.inner or o2.inner
  * we can't use new Outer#Inner since Outer doesn't name an instance of Outer
  * Dependency Injection
  * ===================
  * Abstract Type is is means to implement dependency injection in Scala
  * class Food
  * class Animal{ type suitableFood <: Food; def eat(food:suitableFood)}
  * class Grass extends Food
  * class Cow extends Animal{ type suitableFood = Grass;  def food(food:Grass)}
  * path-dependant Types
  * ====================
  * Outer { Inner }, o1.inner and o2.inner are subtypes of Outer#Inner
  * we can create an object of o1.inner using new o1.inner but we can't use new Outer#Inner
  * Refinement Type
  * =================
  * Animals eating Grass => Animal{ type suitableFood= Grass}
  * var animals: List[Animal{ suitableFood = Grass}]
  * Enumeration
  * =================
  * need to extend scala.Enumeration
      object Grade extends scala.Enumeration{
        val g_1 = Value("I")
        val g_2 = Value("II")
        val g_3 = Value("III")
        val g_4 = Value("IV")
        val g_5 = Value("V")
      }
  * methods are Grade.values, grade.g_3,Grade(1), Grade.g_1.id etc

   */

  /* Chapter 21 (Implicits conversion and parameters)
  * Implicit should be used with vars, def and objects
  * All implicit conversion should be "Single Identifier" and in "scope" or associated with
  * source/target type ( Companion object for Implicit conversion)
  * place of implicit call
  * ======================
  * 1. Implicit conversion to an expected Type
  * 2. Converting the receiver
  * 3. Implicit parameters
  * Map(1->"One",2->"Two"), -> is a method in class ArrowAssoc defined in scala.Predef
  * it also define a implicit conversion from Any to ArrowAssoc in order to use -> method
  * Implicit class
  * ===============
  * Added in 2.10, implicit class generate a implicit def to construct implicit class object
  * Implicit Scope:
  * ==============
  * 1. Local
  * 2. Imported
  * 3. Companion of all type involved in method signature
  * Implicit parameters
  * ====================
  * implicit parameters extends the function call such as someFun(a) => someFun(a)(b)
  * or new someCall(a) => someClass(a)(b)
  * it will construct full last parameter list such as someFun(a) => someFun(a)(b,c,d)
  * The implicit parameter in function can be supplied explicitly also
  * example for implicit parameters are object list sorting family_members.sorted
  * by defining an implicit definition of ordering
  * implicit def familyOrdering: Ordering[Family]=  Ordering.fromLessThan((a,b) => a.age<b.age)
   */

  /* Chapter 22( Implementing Lists)
  * Sealed Abstract class List is having two subclass ::(Final Case class) and Nil(Case Object)
  * List is abstract so can't create new List()...
  * all list methods such as length, drop etc. can be implemented using there main methods:
  * head, tail and isEmpty
  * :: and ::: works with right hand operand
  * The type of element x (x::List(xs)) is of of type List or subtype of List
  * eg. val fruits = List[Fruits], apple:: List[Fruits]
  * here able is subtype of Fruits, the :: method ios implemented as:
  * def ::[B >: A](x: B): List[B] = new scala.::(x, this)
  * Use list Buffer if you need to append and then convert it into List using toList
  * the design of List and ListBuffer is similar to String and StringBuffer
  * Now for list construction we have two choice, one use List to prepend and ListBuffer to Append

   */

  /* Chapter 23( For Expression revisit)
  * high order functions such as - map, flatmap, filter
  * scala compiler translate for loops in high order functions
  * for (seq) expr -> seq has generator and optionally definition and filters
  * for (p <- persons n= p.name if(n.startsWith("A")) yields p.name
  * p <- persons --> generator
  * n= p.name --> definition
  * if(n.startsWith("A") --> filter
  * Translation of for loops
  * =======================
  * for (x <- expr1) yield expr2  -> expr1.map(x=> expr2)
  * for (x <- expr1 if expr2) yield expr3  -> expr1.withFilter(x=> expr2).map(x=> expr3)
  * for (x <- expr1; y <- expr2) yield expr3  -> expr1.flatMap(x=> for(y <- expr2)) yield expr3
  *                                              expr1.flatMap(x=> expr2.map(y<- expr3))

   */

  /* Chapter 26(Extractor)
  * Object with unApply method called extractor
  * apply -> Injection, unapply-> Extraction
  * Most Collections implements "unapplySeq"
  * extraction is heavily used in pattern matching
  * unapply method can also return a Boolean value
  * sequence has implemented unapply so it allows pattern matching
  * unapply can also be used in regular expression pattern matching
  * Regular expression
  * -----------------
  * regular expression is defined in scala.util.matching.Regex
  * it can be constructed using String, raw or using .r operator
  * new Regex("(-)?(\\d+)(\\.\\d+)?") or new Regex("""(-)?(\d+)(\.\d+)?""") or """(-)?(\d+)(\.\d+)?""".r
  * Search for regular patterns
  * ---------------------------
  * regex findFirstIn expr  -> first occurence in expr in Option
  * regex findAllIn expr    -> first All in expr in iterator
  * regex findPrefixOf expr -> first the regex at the start of expr results in Option
  * Regular expression can also be used in pattern matching
  * Regular expression as extractor (-)?(\d+)(\.\d+)?
  * val regEx(sign,intPart,decimalPart) = "-1.23"
  * it can also be used in for loop

   */

  /* Chapter 27(Annotation)
  * Annotation can be used with variables,methods,expressions etc.
  * @deprecated  -- methods, class are not supported in future
  * @volatile - mutable objects will be used in concurrent programming
  * @tailrec - add this annotation to the methods supposed to be tail recursive
  * @unchecked - tells compiler not to worry about missing cases
  * @native - call of native method
   */

  /* Chapter 29(Modular Programming)
  * Abstraction can be achieved by using abstract class or traits
  * use this.<Another Trait> or self.<another Trait> if want to access some objects in another Trait
  * The concrete class need to implement both the traits
  * .type specifies that it is singleton type
   */

  /* Chapter 30(Object Equality)
  * java has two equality operators == and equals
  * for value types == is comparators same as java
  * for reference types, == is same as equals in scala
  * == can't be overridden(defined final in class Any) but equals can be
  * common equality pitfalls are:
  * 1. defining equals with wrong signature,the equals parameter should be any type eg.,equals(obj: Any): Boolean
  * otherwise it will not override super method
  * 2. changing equals without changing hashcode:
  * 3. problem with collections
  * ------------------------
    * HashSet puts the element in hash buckets based on their hash code
    * if we have not overridden hasCode method, it will invoke super method and hence hashCode
    * for p21 and p22 is not same.
    * since the hashcode is different it will be placed in different has buckets
  * 4. issue with mutable object
  * -------------------------
  * pt = Point(1,2) ; pt.x+=1 -> value of x has changed
    * set.contains(pt) will return false.
    * The reason for this is, the new value of x has changed the hash code value and the original
    * hash bucket no longer correspond to new hast Code. so point p41 "dropped out of sight" in hash Set.
    * the pt can still be find using iterator set.iterator.contains(pt) -> true
  * Equal rules
  * -------------
      the equals in Any has below property, for all non-null values
      reflexive: x.equals(x)
      symmetric: x.equals(y) => y.equals(x)
      transitive: x.equals(y) and y.equals(z) => x.equals(z)
      consistent: x.equals(y) => always return true or false
      null, x.equals(null) => false
    * example p1,p2(Point) cp1,cp2(ColorPoint)
    * p1 == p2, symmetric
    * cp1 == p1 but p1 !=, reflexive has failed
    *   remedy: add case class for Point and ColorPoint
    * p1 = cp1, p1= cp2, but cp1!=cp2, transitivity failed
    *   remedy: enforce getClass equality
    *   issue: Anonymous classes, solution canEqual method with isInstanceOf
    * Steps for equal method
    * ----------------------
    * Define canEquals: checks that the argument object is instance of current class
    * canEquals call should take this as argument
    * in equals method ensure that argument type is Any
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
