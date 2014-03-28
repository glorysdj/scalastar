package oo.traits

/**
 * @author dongjie.shi
 *
 * this a example of rich interfaces
 */
trait Ordered[A] extends Any with java.lang.Comparable[A] {
  def compare(that: A): Int
  def <(that: A): Boolean = (this compare that) < 0
  def >(that: A): Boolean = (this compare that) > 0
  def <=(that: A): Boolean = (this compare that) <= 0
  def >=(that: A): Boolean = (this compare that) >= 0
  def compareTo(that: A): Int = compare(that)
}

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  val number = n
  val denom = d
  def compare(that: Rational) = this.number * that.denom - that.number * that.denom
}

object richInterfacesDemo extends App {
  println(new Rational(1, 2) < new Rational(2, 3))
}

