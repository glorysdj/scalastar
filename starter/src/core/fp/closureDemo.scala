package core.fp

/**
 * @author dongjie.shi
 *
 */
object closureDemo extends App {
  var more = 1
  def addMore(x: Int) = x + more
  println(addMore(1))
  more = 5
  println(addMore(1))
}