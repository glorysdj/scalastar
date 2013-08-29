/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object new_control extends App {
  def twice(op: Double => Double, x: Double) = op(op(x))
  println(twice(_ + 1, 5))
  println(twice(_ + 1, 5))
}