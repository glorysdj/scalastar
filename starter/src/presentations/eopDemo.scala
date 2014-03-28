/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object eopDemo extends App {
  val x = if (true) 1 else 0
  println(x)

  def add(x: Int, y: Int) = x + y
  println(add(1, 2))

  def countTo(x: Int) {
    List.range(1, x).foreach(println)
  }
  println(countTo(10))
}