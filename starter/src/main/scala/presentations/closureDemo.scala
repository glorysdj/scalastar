/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object closureDemo extends App {
  var more = 1
  def addMore(x: Int) = x + more
  println(addMore(5))
  more = 5
  println(addMore(5))

  def makeIncreaser(more: Int) = (x: Int) => x + more
  val inc1 = makeIncreaser(1)
  val inc100 = makeIncreaser(100)
  println(inc1(10))
  println(inc100(10))
}