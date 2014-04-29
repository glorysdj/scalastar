package core.oo.classes

/**
 * @author dongjie.shi
 * this is a example of stateful class/ mutable class
 */
class Time {
  private[this] var h = 12
  private[this] var m = 0
  private[this] var s: Int = _
  def hour: Int = h
  def hour_=(x: Int) { h = x }
  def minute: Int = m
  def minute_=(x: Int) { m = x }
  def second: Int = s
  def second_=(x: Int) { s = x }
}

object mutableClassDemo extends App {
  val t = new Time()
  t.hour = 1
  t.minute = 2
  t.second = 3
  println(t.hour, t.minute, t.second)
}