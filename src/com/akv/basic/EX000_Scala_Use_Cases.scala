package com.akv.basic

object EX000_Scala_Use_Cases {

  /*
   Important scala features:
   ------------------------
   1. for loops -> yield values
   2. pattern matching
   3. functions -> first-order/higher order, nested function,function literals, partial functions, closure, curried functions

      Loan pattern example
      ---------------------
       connection(f){
       open
       {f}
       finally{close}

   4. options:
       user case 1:

             get("/supplier/:supplierId", operation(getSupplier)) {
            val rawId = params("supplierId")
            (Try(rawId.toLong).toOption match {
              case Some(supplierId) => supDb.findSuppliers(Seq(supplierId)).headOption
              case _ => None
            })

       user case 2:

            DB call return Option, Some if fetched, None if not data

   5. Extractors:
    Read a file, it will return a Array of String
    convert it to list and apply a case to construct a object

   6. abstract Types(var/vals, Type,Methods)
      trait with a Type, concrete class defines
   7. abstract Type example:
        Food, Animal, SuitableFood

   8. examples for curried functions
      select (sql: String, params: Any*)(f: ResultSet => T)




   */

}
