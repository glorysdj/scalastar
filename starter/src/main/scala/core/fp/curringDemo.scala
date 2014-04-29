package core.fp

/**
 * @author dongjie.shi
 *
 */
object curringDemo extends App {
  val power = (x: Int, y: Int) => scala.math.pow(x, y)
  val p2 = (x: Int) => power(x, 2)
  val p3 = (x: Int) => power(x, 3)
  println(power)
  println(p2, p2(2))
  println(p3, p3(2))

  def curriedSum1(x: Int, y: Int) = x + y
  def curriedSum2(x: Int)(y: Int) = x + y
  def curriedSum3(x: Int) = (y: Int) => x + y
  val curriedSum4 = (x: Int) => (y: Int) => x + y
  println(curriedSum1(1, 2), curriedSum2(1)(2), curriedSum3(1)(2), curriedSum4(1)(2))
}