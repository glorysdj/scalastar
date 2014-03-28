/**
 *
 */
package oo.classes

/**
 * @author dongjie.shi
 * this is a example of functional class/ immutable class
 */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val number = n / g
  val denom = d / g
  println("Created " + this)

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(this.number * that.denom + that.number * this.denom, this.denom * that.denom)

  def +(i: Int): Rational =
    new Rational(this.number + i * this.denom, this.denom)

  def -(that: Rational): Rational =
    new Rational(this.number * that.denom - that.number * this.denom, this.denom * that.denom)

  def -(i: Int): Rational =
    new Rational(this.number - i * this.denom, this.denom)

  def *(that: Rational): Rational =
    new Rational(this.number * that.number, this.denom * that.denom)

  def *(i: Int): Rational =
    new Rational(this.number * i, this.denom)

  def /(that: Rational): Rational =
    new Rational(this.number * that.denom, this.denom * that.number)

  def /(i: Int): Rational =
    new Rational(this.number, this.denom * i)

  def compare(that: Rational) = this.number * that.denom - that.number * that.denom

  override def toString = this.number + "/" + this.denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object Rational {
  def apply(n: Int, d: Int) = new Rational(n, d)
  def apply(n: Int) = new Rational(n)
}

object functionalClassDemo extends App {
  val r1 = new Rational(1, 2)
  val r2 = Rational(4, 6)
  println(r1 + r2)
  println(r1 - r2)
  println(r1 * r2)
  println(r1 / r2)
  println(r1 + 2)
  println(r1 - 2)
  println(r1 * 2)
  println(r1 / 2)
  println(r1 + r1 * r2)

  implicit def intToRational(x: Int) = new Rational(x)
  println(2 + r1)
  println(2 - r1)
  println(2 * r1)
  println(2 / r1)

  println(r1 < r2)
  println(r1 <= r2)
  println(r1 > r2)
  println(r1 >= r2)
}