package com.akv.basic

object EX013_6_Control_abstraction_contd extends App{

  val aList = List(1,4,5,-3,5,-1)

  object ListComparision {
    def containsNegative(list: List[Int]) ={
      var found = false
      for (num <-list){
        if (num<0) {
          found =true
        }
      }
      found
    }
    def contains(list: List[Int]) ={
      var found = false
      for (num <-list){
        if (num==0) {
          found =true
        }
      }
      found
    }
  }


  println(ListComparision.containsNegative(List(2,4,5,-6,2)))
  println(ListComparision.containsNegative(List(1,2,3,4,5)))

  // Note : the above code is equivalent to this
  println(List(2,4,5,-6,2).exists(_<0))
  println(List(1,2,3,4,5).exists(_<0))


  object ListComparision2 {
    private def numberMatcher(list: List[Int],matcher: (Int)=>Boolean) ={
      var found = false
      for (num <-list){
        if (matcher(num)) found =true

      }
      found
    }

    def containsNegative(list:List[Int]) ={
      numberMatcher(list,(_:Int) < 0)
    }
    def exists(list:List[Int],num:Int) ={
      numberMatcher(list,(_:Int) == num)
    }
  }

  println(ListComparision2.containsNegative(List(2,4,5,-6,2)))
  println(ListComparision2.exists(List(1,2,3,4,5),11))


}
