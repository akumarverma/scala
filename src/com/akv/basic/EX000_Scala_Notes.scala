package com.akv.basic

object EX000_Scala_Notes {
  /*
  * Chapter 2(Variables and functions):
  * val : can not be re-assigned(similar as final in Java)
  * var : can be reassigned ( non-final in java)
  * def max(a;Int,b:Int): Int = a+b, Method definition
  * Scala Loops -> while, for, for each
  * loop ex. List("Amit","Swati","Shubh","Prisha")
  * iterate using while, foreach and for
  * member in for is a val not var, it get new value in each iteration
   */

  /*
  * Chapter 3(Arrays,List,tuple,map and set)
  * Arrays
  * ======
  * the val can't be assigned to another variable, but the array content can be modified
  * Array(1) ="A" ==> Array.update(1,"A")
  * Array(1) => Array.apply(1)
  * Array length can't be changed, but content can be
  * List
  * =====
  * :: is right operand 1:: List(2,3) ==> List(2,3).::(1)
  * 1::2::3::Nil => 1::2::(Nil.::(3)) ==> 1::((Nil.::(3)).::(2)) ==> ((Nil.::(3)).::(2)).::(1)
  * List :: prepend to list, +: append the element to List, but it is saldomly used since it require
  * fill list traversal
  * Options for append are: prepend elements and then reverse
  * Use ListBuffer and finally use toList method
  * Tuple
  * =======
  * tuple doesn't access list method as aTuple(0) since each element is of different type
  * elements are accessed as ._1,._2
  * the type of tuple depends on number of argument and type of argument
  * Map and Sets
  * =============
  * Have immutable and mutable versions, have trait Set and Map and again sub trait with the same
  * name in package scala.collection.immutable/mutable collection
  * uses + method to add new element in immutable whereas += on mutable collection
   */

  /*
  * Chapter 4(Classes and Objects)
  * Scala doesn't have static method but have singleton objects(starts with object)
  * if one file is having class and object with same name, it is called companion
  * singleton objects(also called first-class objects) are more than just defining static methods/fields
  * it can extends superclass and mix in traits
  * singleton object can't take parameters since it can't instantiate objects
  * A object not sharing name with companion class are called "standalone Objects"
  * such as object having main method
   */

  /* Chapter 5 (Scala types)
  * Any -> AnyVal -> Byte,short,int,long,float,double,char,boolean,unit
  * String Interpolation -> s, f and raw
  * infix operator, operator sits between object and parameter
  * prefix operators(unary) + - ! ~
  * Postfix operators, take no parameter such as toList, toUpperCase etc
  * Arithmetic operator: + - * / %
  * relational Operator: > >= < <= != == !
  * Logical Methods && ||
  * Logical && and || are short-circuit, it means the other operands will be evaluated
  * only if need
  * use & or | if you want all expression to be evaluated
  * == method in scala invokes equals method
  * Rich wrappers( such as RichInt) provides many methods like:
  * max,min,abs, round, isInfinity, to etc.
  * Rich wrapper using implicit conversion to convert from let us say int to RichInt defined in prefDef

   */

  /* Chapter 6(Functional Objects-> parameters, constructor, require,overloading)
  * scala class definition takes parameters used to construct object
  * Anything not part of method in class are part of constructor
  * pre-condition: require(...), failing require will stop object construction
  * Auxiliary constructor: Class has can multiple auxiliary constructor but all will end up in calling
  * primary constructor
  * only primary constructor can invoke super constructor
  * Scala allows to use natural operator as methods such as +,-,*,/ etc
  * other point - method overloading, implicit conversion
   */

  /* chapter 7 (Built-in Controls -> if, while,for,match, try and function calls)
  * if, while, for
  * =================
  * all controls result in value, they are expressions
  * while and do-while are loops not expression, they don't return a value
  * var and while go hand in hand, double check the logic if while is really needed
  * while can be written as foreach or for
  * for loops are: foreach, for (arg <- args)
  * for expression can take if parameters
  * integer list (1 to 5) (i until 5)
  * for loop can ne nested
  * for loop can create another collection using yield
  * Exception handling
  * ===================
  * scala throw exception as throw new RuntimeException
  * return value of exception is Nothing
  * the try catch block returns a value and the value derives of try/catch block
  * catch statement syntax follows pattern matching syntax
  * finally clause is used to clean up the resources such as file, db connection or socket
  * and should not return value
   */

  /* Chapter 8(Functions, first class function, function literals,Closure and partial Functions)
  * A function can have another function defined locally. The local function can refer
  * the parameters and variables of enclosing function
  * function literals x=> x+1, compiler translate it to an class
  * since it is an class, we can assign it to a variable like val x= (x:Int)=> x+1
  * if used in conjunction with collections, parameter type will in inferred, hence not needed(target Typing)
  * parameters can be _ like list.filter(_>0) is equivalent to list.filter(x=> x>0)
  * Multiple underscore means multiple parameters
  * Partial Functions
  * ===================
  * creating a function literal with some/none values of a function result in partial functions
  * such as val parDef = sum _ where sum is def sum(a,b,c) => a+b+c
  * partial functions can use some or none parameters
  * it create an class whose object's apply method take the missing parameter and invokes the apply method
  * closure
  * ========
  * binding free variables such as inc(x) = x+more, here more is free variable
  * change in free variable is visible in closure
  * def inc(more) = (x)=> x+ more is a closure
  * val x = inc(1) is a partial function and 1 is bind to more
  * variable, default, named argument
  * =================================
  * *args -> one or more argument
  * def f(x:int=5) 5 is default parameter
  * Named parameter allow to invoke function with different order to parameters
   */

  /* Chapter 9(Control Abstraction)
  * higher order functions reduce code duplication
  * Currying -> having multiple parameter list
  * it is calling functions one after another
  * Closure is very important for patterns like opening a DB, operate on it and close resources
  * called loan pattern, resource is created and loaned to another process
  * if function is just having one parameter it can be called using {} instead of ()
  * Curried function loan pattern, get result set and create object
  * By name and by value diff
  * by Name: f(predicate :=> boolean) -> it will be evaluated at runtime
  * by value f(predicate: B=boolean) -> it will be evaluated with call
  * read DB fetch and object creation as example of curried function
   */

  /* Chapter 10(Composition and Inheritance)
  * Abstract Class, val/def, parameter less/empty parameter
  * Method override, subclass
  * ====================
  * Members with no definition are abstract members, abstract keyword is not required for methods
  * but required for classes having abstract methods.
  * we should be defining empty-paran methods for methods having side effects whereas parameter less
  * methods if it just access some properties.
  * a def with no parameter can be defined with () or without ()
  * Note : a parameter less def can also be written as variable
  * variable takes memory whereas def will be evaluates each time when invoked
  * Invoking super class constructor eg. class Child(override val x:Int) extends Parent(x)
  * child can be of Type parent -> val child:Parent = new Child(18)
  * override is required of overriding parent concrete method, for abstract method it is optional
  * it is not allowed for non-parent class methods
  * class Tiger(override val dangerous: Boolean,val age:Int) extends Cat
  * or it is be overridden in subclass body
  * parameter less def can be overridden by val
  * val in class parameter is shorthand for class field
  * Final method can not be overridden by child class
  * polymorphism -> based on object reference, method will be called
   */

  /* chapter 11( Scala hierarchy)
  * Any is parent of all class is scala
  * AnyVal is parent of : Byte, Short, Int, Long, Float, Double, Character, Boolean and Unit
  * AnyRef is parent of : String, Iterable etc..
  * AnyRef === java.lang.object
  * Nothing is subclass of all class
  * Null is subclass of all ref classes
  * All class inherit methods such as ==, !=, hasCode, toString, equals from "Any"
  * == and != are defined final in "Any" class
  * Java == methods compares value for primitive type and reference for object type
  * whereas scala invokes the equals method of the object
  * scala eq method defined in "AnyRef" class compare the reference equality
  * Null is subclass of all reference class, it is not compatible with value class
  * val x:Int = 5 is wrong ???
  * Nothing is subclass of all classes( inherit from AnyVal or AnyRef), it is especially useful in case
  * of exceptions. throw new Exception returns Nothing type.
  * Implicit conversion
  * ===================
  * scala.runtime.richInt defines max, min, to, until operations
  * scala.runtime.richInt also defines an implicit conversion from Int to RichInt
  * it means we can use max min to until operators on Int
  */

  /* Chapter 12(Traits)
  * traits are similar as java interface. it can have concrete methods and fields.
  * it can not be instantiated, so will not take parameters.
  * Traits are also Type same as Class
  * a class can extend/mixin mixing multiple traits(with)
  * Ordered trait provide methods to compare such as <, >,<= and >=
  * need to define abstract "compare" method in implementing class
  * Traits can modify the class behaviour. the concept is called stackable Modifications, steps:
  * 1. define an abstract class for queue(IntQueue)
  * 2. define a concrete class of abstract queue(BasicIntQueue)
  * 3. Define a trait doubling by extending abstract Class(IntQueue)
  * 4. override method such as
  *       abstract override def put(x:Int):IntQueue = super.put(x*2)
  * 5. create a new class extending BasicIntQueue and doubling Trait
  *       class myDoubleIntQueue extends BasicIntQueue with Doubling
  * if a trait extends a superclass, then it can be mixin only with class extending that super class
  * eg. doubling trait can only be mixin with class extending IntQueue such as BasicIntQueue
   */

  /* Chapter 13( Packages and Imports)
  *
  * Class in same package can be referenced without package qualifier
  * Import allows member of a package available without qualifying its full name
  * import all package._ not package.*( different from Java)
  * Import in scala can appear anywhere
  * package can also be imported such as java.util.matching.regex and use pattern as regex.pattern
  * package import can hide and rename the import
  * eg. com.akv.{Animal, Fruit} // only Animal and Fruit are imported
  * eg. com.akv.{Animal => MyAnimal, Fruit} // Animal is renamed as MyAnimal
  * eg. java.sql.{Date => SqlDate}
  * eg com.akv.Fruits{Pears => _,_) // import everything except Pears
  * eg. com.akv.Fruits._ is equivalent to com.akv.Fruits.{_}
  * eg. com.akv.Fruits.Apple is equivalent to com.akv.Fruits.{Apple}
  * java.lang, scala and predef are imported implicitly
  * In these 3 implicit imports, the later overshadowed previous
  * Access Modifier
  * ===================
  * Anything not qualified is public
  * private: Accessed inside class or nested class inside class
  * Protected: Accessible only from subClass but not from package( Unlike Java)
  * _root_ refers as parent of top level package
  * Companion Objects can access each others private members
  * private[X] or protected[X] means that access is private or protected "up to" X,
  * where X designates some enclosing package, class or singleton object

   */

  /* Chapter 15(Case class and Pattern Matching
  * Case Class
  * ==============
  * case class can create instance without new(implementing companion objects)
  * case class parameters are val, so parameters are member fields
  * objects can be copied and optionally modified during copy
  * implements equals, copy, hashcode and toString methods
  * case classes enables pattern matching
  * Match
  * ======
  * switch expr {} vs expr match {}
  * scala match is a expression
  * no need of having break
  * MatchError is thrown if no match case found
  * use @unchecked annotation or wildcard(_) throw RuntimeException to avoid MatchError
  * Pattern Matching
  * =================
    * 1. Constant and wildcard pattern, constant matches values wrt ==
    * 2. pattern matching using variables, it will match all cases and can be used on RHS of =>
    * 2.1 pattern matching using wildcard _ matches all cases, but can not be used in RHS of =>
    * 3. pattern matching using seq eg. case seq(_,_,_), seq(0,_*)
    * 4. pattern matching using tuple eg. case (1,2,3)
    * 5. pattern matching using Type case s: String or case m: Map{String,Int]
    * 6. pattern matching using class, eg: case BinOP("+",Number(a),Number(b))
    * 7. pattern matching using Option, Some and None, eg. Case Some(2), Case None
  * Pattern guard comes after pattern and starts with if
  * specific pattern should come first followed by generic one, wildcard(_) variable pattern should come
  * at the end
  * patterns everywhere example
  * ===========================
  * 1. de-structuring tuple eg,  (a,b,c) = aTuple
  * 2. destructuring case class eg. BinOP(op,expr1,expr2) = binOp
  * 3. Map destructing in for loop eg, for ((country,capital) <- capitals)
  * 4. for (Some(x) <- aList) println(x) , filter any None value
  * case sequence as function literals, eg.
  * ============================================
  * val second:List[Int] => Int = {
  *     case x:: y:: _ =>y
  *     }
  *
  * instead of having single entry point with parameters, case sequence provide multiple entry points
  *
  * PartialFunction and isDefinedAt
  * ===============================

      // Example written with PartialFunctions
      val second:PartialFunction[List[Int],Int] = {
        case x:: y:: _ =>y
      }

      // Note : partial functions has isDefinedAt method
      println(second2.isDefinedAt(List(1,2,3)))  // true
      println(second2.isDefinedAt(List()))       // false

  * Sealed Classes
  * ================
  *  a sealed class can't have subclass in other files
   * pattern matching against a class inherit from selaed class give warning if all matching cases are not
   * taken into account
   * sealed keyword is often a licence of pattern matching
   * Option
   * ========
   * Some(x)/None
   * Scala Map.get or find method returns a Option
   *
   */

  /* Chapter 16(List)
  * Lists are similar to array but immutable
  * Lists are implemented as linked list whereas Arrays are flat
  * Lists are homogeneous
  * List are covariant, eg. List[String] is subtype of List[Object]
  * Empty list are of type List[Nothing]
  * Basic list operations are head, tail and isEmpty
  * All list are build using two fundamental construct nil, :: (cons)
  * List methods
  * head, tail, isEmpty, reverse, init,last, length, mkString,toString
  * drop, take, splitAt, flatten,zip,unzip
   */

  /* Important scala features:
   for loops -> yield values
   pattern matching
   functions -> first-order/higher order, nested function,function literals, partial functions, closure, curried functions
   traits
   options
   Extractors
   abstract Types(var/vals, Type,Methods)
   abstract Type example?

   examples for curried functions

   */

}
