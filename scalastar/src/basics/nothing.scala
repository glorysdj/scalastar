/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object nothing extends App {
  def error(msg: String): Nothing =
    throw new RuntimeException(msg)

  def divide(x: Int, y: Int): Int =
    if (y != 0) x / y
    else error("can't divide by zero")

  println(divide(2, 3))
  println(divide(2, 0))
}