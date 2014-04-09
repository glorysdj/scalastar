/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object functions extends App {

  def factorial(x: BigInt): BigInt = {
    if (x == 0) {
      return 1
    } else {
      return x * factorial(x - 1)
    }
  }

  val begin = System.nanoTime
  println(factorial(30))
  val end = System.nanoTime
  println(end - begin)

  def max(x: Int, y: Int): Int = { if (x > y) x else y }
  println(max(2, 5))
  
  def echo(x: String*) = x.foreach(println _)
  echo("hello", "scala")
}