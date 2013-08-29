/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object highOrderFunction extends App {
  def add(x: Int, y: Int): Int = x + y
  val sub = (x: Int, y: Int) => x - y
  def mul(x: Int, y: Int): Int = x * y
  val div = (x: Int, y: Int) => x / y

  def hof(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)

  println(hof(1, 2, add))
  println(hof(1, 2, sub))
  println(hof(1, 2, mul))
  println(hof(1, 2, div))
}