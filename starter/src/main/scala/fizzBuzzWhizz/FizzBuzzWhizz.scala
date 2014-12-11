/**
 *
 */
package fizzBuzzWhizz

import scala.annotation.tailrec

/**
 * @author donshi
 *
 */
object FizzBuzzWhizz extends App {
  val keys = List(3, 5, 7)
  val words = List("Fizz", "Buzz", "Whizz")
  val map = keys.zip(words).toMap
  val students = List.range(1, 100).map(_.toString)
  @tailrec
  def containsNum(x: Int, n: Int): Boolean = {
    if (x % 10 == n) true
    else if (x / 10 == 0) false
    else containsNum(x / 10, n)
  }
  def fraction: PartialFunction[String, String] = {
    case x if (containsNum((students.indexOf(x) + 1), keys(0))) => words(0)
    case x if (students.indexOf(x) + 1) % (keys(0) * keys(1) * keys(2)) == 0 => words(0) + words(1) + words(2)
    case x if (students.indexOf(x) + 1) % (keys(0) * keys(1)) == 0 => words(0) + words(1)
    case x if (students.indexOf(x) + 1) % (keys(0) * keys(2)) == 0 => words(0) + words(2)
    case x if (students.indexOf(x) + 1) % (keys(1) * keys(2)) == 0 => words(1) + words(2)
    case x if (students.indexOf(x) + 1) % keys(0) == 0 => words(0)
    case x if (students.indexOf(x) + 1) % keys(1) == 0 => words(1)
    case x if (students.indexOf(x) + 1) % keys(2) == 0 => words(2)
    case x => x
  }
  students collect fraction foreach println
}