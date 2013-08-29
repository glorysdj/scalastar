/**
 *
 */
package basics.oo.recommended

/**
 * @author dongjie.shi
 *
 */
trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def append[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[+T](private val leading: List[T], private val tailing: List[T]) extends Queue[T] {
    def head = mirror.leading.head
    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.tailing)
    }
    def append[U >: T](x: U) = new QueueImpl(leading, x :: tailing)
    override def toString = leading.mkString(",") + "," + tailing.mkString(",")

    private def mirror = {
      if (leading.isEmpty) {
        new QueueImpl(tailing.reverse, Nil)
      } else {
        this
      }
    }
  }
}

object QueueApp extends App {
  val q = Queue(1, 2, 3, "hello", "5")
  println(q.getClass)
  println(q)
  println(q.head)
  println(q.tail)
  println(q append 6)
}