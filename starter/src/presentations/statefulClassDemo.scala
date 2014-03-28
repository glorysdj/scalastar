/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object statefulClassDemo extends App {
  val t1 = new Time
  println(t1, t1.hour, t1.minute)
  t1.hour = 15
  t1.minute = 58
  println(t1, t1.hour, t1.minute)
}

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

class Time2 {
  var hour = 12
  var minute = 0
}