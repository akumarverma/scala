package com.akv.advance

object EX029_01_Modular_Programming extends App{

  /*
  * Abstraction can be achieved by using abstract class or traits
  * below example uses abstract Client class to achieve dependency injection
  * use this.<Another Trait> or self.<another Trait> if want to access some objects in another Trait
  * above is exemplified in simpleRecipe trait below
  * The concrete class need to implement both the traits
  * .type specifies that it is singleton type

   */

  // Create Food and Recipe Class
  class Food(val name:String){
    override def toString: String = name
  }
  class Recipe(val name:String,val ingredients :List[Food],val instruction:String){
    override def toString: String = name
  }

  // create few singleton objects of Food and Recipe
  object apple extends Food("Apple")
  object pear extends Food("Pear")
  object orange extends Food("Orange")
  object cream extends Food("Cream")
  object sugar extends Food("Sugar")
  object frozenFoods extends Food("Frozen Foods")

  object fruitSalad extends Recipe("Fruit Salad",List(apple,orange,cream,sugar),"Stir it well")
  object heatItUp extends Recipe("Frozen Recipe",List(frozenFoods),"Heat it up for 15 minutes")

  // create trait to define Food categories and extends it in Database class
  trait FoodCategories {

    case class Categories(name: String,foods: List[Food])
    def allCategories: List[Categories]

  }
  // create a abstract database class to get the food and recipe details
  abstract class Database extends FoodCategories {
    def allFood:List[Food]
    def getFood(name:String):Option[Food] = allFood.find(_.name==name)
    def allRecipe:List[Recipe]


  }

  trait SimpleFood {
    object waterMelon extends Food("WaterMelon")
    def allFood:List[Food] = List(apple,waterMelon)
  }

  trait simpleRecipe {
    self:SimpleFood =>  // important of self.SimpleFood to access waterMelon object
    object anotherFruitSalad extends Recipe("Another Fruit Salad"
      ,List(apple,orange,waterMelon)
      ,"Mix it well")
    def allRecipe:List[Recipe] = List(fruitSalad,anotherFruitSalad)

  }
  // a singleton object extending database class
  object simpleDatabase extends Database with SimpleFood with simpleRecipe {

    def allCategories: List[Categories] = categories

    private val categories = List(Categories("Fruits",List(apple,orange,pear)),
      Categories("misc",List(sugar,cream)))


  }

  // another implementation of abstract database class
  object anotherDatabase extends Database {
    def allFood:List[Food] = List(frozenFoods)
    def allRecipe:List[Recipe] = List(heatItUp)

    def allCategories: List[Categories] = categories

    private val categories = List(Categories("edible",List(frozenFoods)))

  }

  // an abstract class for class
  abstract class Client{
    val database: Database
    def receiptUsingFood(food: Food):List[Recipe] = {

      val receiptList = database.allRecipe

      for(i<- receiptList; if i.ingredients.contains(food)) yield i
    }

    def displayCategories() ={
      database.allCategories
    }

    def findCategories(category: database.Categories) ={
      println(category)
    }

  }

  // dependency injection, injecting actual database implementation class
  object simpleClient extends Client {
    val database = simpleDatabase
  }

  // another client implementation using anotherDatabase
  object anotherClient extends Client {
    val database = anotherDatabase
  }

  // using simpleClient and simpleDatabase
  println(simpleClient.receiptUsingFood(apple))
  println(simpleClient.receiptUsingFood(pear))
  println(simpleClient.displayCategories())

  // using anotherClient and anotherDatabase
  println(anotherClient.receiptUsingFood(frozenFoods))
  println(anotherClient.receiptUsingFood(pear))
  println(anotherClient.displayCategories())

  // Linking at run time

  val env = "DEV"

  val db = if (env=="DEV") simpleDatabase else anotherDatabase

  object runtimeClient extends Client{
    val database = db
  }

  // using anotherClient and anotherDatabase
  println(runtimeClient.receiptUsingFood(apple))
  println(runtimeClient.receiptUsingFood(pear))
  println(runtimeClient.displayCategories())

  val category = runtimeClient.database.allCategories.head

  println(category)

  runtimeClient.findCategories(category)
  /*
  anotherClient.findCategories(category)   // will not compile
  Error:(146, 32) type mismatch;
  found   : com.akv.advance.EX029_01_Modular_Programming.runtimeClient.database.Categories
  required: com.akv.advance.EX029_01_Modular_Programming.anotherClient.database.Categories
  anotherClient.findCategories(category)
  */

  /* Another failure, this this case comipler is not above to identify that
  * db and runtimeClient.database are same
  * This case be alleviated by writing runTimeClient as
  *   object runtimeClient extends Client{
  *     val database:db.type = db
  *  }
  for (cat <- db.allCategories) runtimeClient.findCategories(cat)
  Error:(154, 62) type mismatch;
  found   : com.akv.advance.EX029_01_Modular_Programming.db.Categories
  required: com.akv.advance.EX029_01_Modular_Programming.runtimeClient.database.Categories
  for (cat <- db.allCategories) runtimeClient.findCategories(cat)
  */
}
