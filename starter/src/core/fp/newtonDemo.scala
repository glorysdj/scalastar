package core.fp

/**
 * @author dongjie.shi
 *
 */
object newtonDemo extends App {
  val min = 0.0000000001

  val square = (x: Double) => x * x
  val cube = (x: Double) => x * x * x
  val mul4 = (x: Double) => x * x * x * x
  val f5 = (x: Double) => 4 * x * x * x - 3 - x * x + 9

  def derivative(f: (Double => Double), dx: Double) = (x: Double) => (f(x + dx) - f(x)) / dx

  def newton_improve(f: (Double => Double), x: Double, g: Double) = g - (f(g) - x) / derivative(f, 0.00001)(g)

  def isGoodEnough(value: Double, guess: Double, f: (Double) => Double) = if ((value - f(guess)).abs <= min) true else false

  def improve(value: Double, guess: Double, f: (Double, Double) => Double): Double = f(value, guess)

  def approximate(value: Double, guess: Double, f: (Double) => Double): Double =
    if (isGoodEnough(value, guess, f)) guess
    else approximate(value, newton_improve(f, value, guess), f)

  println(approximate(5, 1, square), square(approximate(5, 1, square)))
  println(approximate(5, 1, cube), cube(approximate(5, 1, cube)))
  println(approximate(5, 1, mul4), mul4(approximate(5, 1, mul4)))
  println(approximate(5, 1, f5), f5(approximate(5, 1, f5)))
}