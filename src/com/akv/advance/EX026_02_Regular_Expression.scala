package com.akv.advance
import scala.util.matching.Regex

object EX026_02_Regular_Expression extends App{

  val regEx = new Regex("(-)?(\\d+)(\\.\\d+)?")     // using String
  println(regEx)

  val regEx2 = new Regex("""(-)?(\d+)(\.\d+)?""")   // Using raw String
  println(regEx2)

  val regEx3 = """(-)?(\d+)(\.\d+)?""".r            // Using .r
  println(regEx3)

  /*
  * Search for regular patterns
  * regex findFirstIn expr  -> first occurence in expr in Option
  * regex findAllIn expr    -> first All in expr in iterator
  * regex findPrefixOf expr -> first the regex at the start of expr results in Option
   */

  val expr = "-1.5 is less than 1.5 and the diff is 3.0 but the sum is 0"
  println(regEx.findFirstIn(expr.toCharArray))
  println(regEx.findPrefixOf(expr.toCharArray))

  for (i <- regEx.findAllIn(expr.toCharArray)) println(i)

  // Regular expression as extractor (-)?(\d+)(\.\d+)?

  val regEx(sign,intPart,decimalPart) = "-1.23"

  println(s" $sign $intPart $decimalPart")

  val regEx(sign2,intPart2,decimalPart2) = "1.23"

  println(s" $sign2 $intPart2 $decimalPart2") // sign is null

  // In a Loop
  for( regEx(s,i,d) <- regEx.findAllIn(expr.toCharArray)) println(s"$s $i $d")

}
