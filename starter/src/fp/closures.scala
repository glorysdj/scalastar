package fp

/**
 * @author dongjie.shi
 *
 */
object closures extends App {
  var more = 1
  def addMore(x: Int) = x + more
  println(addMore(5))
  more = 5
  println(addMore(5))
}