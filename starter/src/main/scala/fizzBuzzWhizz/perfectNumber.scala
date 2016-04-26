package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object perfectNumber extends App {
  
  def isPerfect(num: Long): Boolean = {
    require(num > 0)
    num == aliquotSum(num)
  }

  def isAbundant(num: Long): Boolean = {
    require(num > 0)
    num < aliquotSum(num)
  }

  def isDeficient(num: Long): Boolean = {
    require(num > 0)
    num > aliquotSum(num)
  }

  def aliquotSum(num: Long) = {
    require(num > 0)
    getFactors(num).sum
  }

  def getFactors(num: Long) = {
    require(num > 0)
    List.range(1, num).filter(num % _ == 0)
  }

  //List.range(1, 1000).map(i => (i, getFactors(i))).foreach(println)
  //List.range(1, 1000).map(i => (i, isPerfect(i))).foreach(println)
  //List.range(1, 10000).filter(isPerfect(_)).foreach(println)
  
  val (perfects, nonperfects) = List.range(1, 10000).partition(isPerfect(_))
  val (abundants, deficients) = nonperfects.partition(isAbundant(_))
  println(perfects)
  println(abundants)
  println(deficients)
}