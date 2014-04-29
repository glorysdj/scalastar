/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object firstClassAndHighOrderFunctionDemo extends App {
  def add(x: Int, y: Int): Int = x + y
  val sub = (x: Int, y: Int) => x - y
  def mul(x: Int, y: Int): Int = x * y
  val div = (x: Int, y: Int) => x / y

  def hof(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)

  println(hof(1, 2, add))
  println(hof(1, 2, sub))
  println(hof(1, 2, mul))
  println(hof(1, 2, div))
  println(hof(1, 2, (x: Int, y: Int) => x + y))
  println(hof(1, 2, (x, y) => x - y))
  println(hof(1, 2, (_: Int) * (_: Int)))
  println(hof(1, 2, _ / _))

  println(() => "")
  println(() => 5)
  println(() => Unit)
  println((x: Int) => x + 1)
  println((x: Int, y: Int) => x + y)
  println((a: Int, b: String, c: Double, d: Long, e: Byte, f: Float) => Unit)
}