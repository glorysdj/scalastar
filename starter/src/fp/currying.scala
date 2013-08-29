package fp

/**
 * @author dongjie.shi
 *
 */
object currying extends App {
  def power(x: Int, y: Int) = scala.math.pow(x, y)
  val p2 = (x: Int) => power(x, 2)
  val p3 = (x: Int) => power(x, 3)
  println(p2(2))
  println(p3(2))

  def computation(a: Int, b: Int, c: Int, d: Int) = (a + scala.math.pow(b, 2) + scala.math.pow(c, 3) + scala.math.pow(d, 4))
  val fill_a = (b: Int, c: Int, d: Int) => computation(1, b, c, d)
  val fill_b = (c: Int, d: Int) => fill_a(2, c, d)
  val fill_c = (d: Int) => fill_b(3, d)
  val fill_d = () => fill_c(4)
  println(fill_a, fill_b, fill_c, fill_d)
  println(fill_a(2, 3, 4), fill_b(3, 4), fill_c(4), fill_d())

  def curriedSum(x: Int)(y: Int) = x + y
  println(curriedSum(1)(2))
  def curriedSum2(x: Int) = (y: Int) => x + y
  println(curriedSum2(1), curriedSum2(1)(2))
  val curriedSum3 = (x: Int) => (y: Int) => x + y
  println(curriedSum3, curriedSum3(1), curriedSum3(1)(2))
  
}