package core.fp

import scala.annotation.tailrec

/**
 * @author dongjie.shi
 *
 */
object recursionDemo extends App {

  def factorial(number: BigInt): BigInt = {
    if (number == 1)
      return 1
    number * factorial(number - 1)
  }
  val begin = System.nanoTime
  val res = factorial(1000)
  val end = System.nanoTime
  println(res, end - begin)

  @tailrec
  def factorial(accumulator: BigInt, number: BigInt): BigInt = {
    if (number == 1)
      return accumulator
    factorial(number * accumulator, number - 1)
  }
  val begin2 = System.nanoTime
  val res2 = factorial(1, 1000)
  val end2 = System.nanoTime
  println(res2, end2 - begin2)
}