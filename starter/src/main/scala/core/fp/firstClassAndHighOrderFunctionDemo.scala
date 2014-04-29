package core.fp

/**
 * @author dongjie.shi
 *
 */
object firstClassAndHighOrderFunctionDemo extends App {
  //first class functions
  def add(x: Int, y: Int): Int = { x + y }
  def sub(x: Int, y: Int) = { x - y }
  val mul = (x: Int, y: Int) => x * y
  val div = (x: Int, y: Int) => x / y

  //high order functions
  def hof(x: Int, y: Int, f: (Int, Int) => Int) = f(x, y)

  println(hof(1, 2, add))
  println(hof(1, 2, sub))
  println(hof(1, 2, mul))
  println(hof(1, 2, div))
  //lambdas
  println(hof(1, 2, (x: Int, y: Int) => x + y))
  println(hof(1, 2, (x, y) => x - y))
  println(hof(1, 2, (_: Int) * (_: Int)))
  println(hof(1, 2, _ / _))

  //function traits
  println(() => "")
  println(() => 5)
  println(() => Unit)
  println((x: Int) => x + 1)
  println((x: Int, y: Int) => x + y)
  println((a: Int, b: String, c: Double, d: Long, e: Byte, f: Float) => Unit)
}