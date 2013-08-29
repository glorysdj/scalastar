/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class Queue[T] private (private val leading: List[T], private val tailing: List[T]) {

  def this() = this(Nil, Nil)

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.tailing)
  }
  def append(x: T) = new Queue(leading, x :: tailing)

  private def mirror = {
    if (leading.isEmpty) {
      new Queue(tailing.reverse, Nil)
    } else {
      this
    }
  }

}

object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}