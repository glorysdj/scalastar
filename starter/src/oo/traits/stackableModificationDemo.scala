package oo.traits

import scala.collection.mutable.ArrayBuffer

/**
 * @author dongjie.shi
 *
 * this is a example of Stackable Modification
 */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get(): Int = { buf.remove(0) }
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) { if (x >= 0) super.put(x) }
}

object stackableModificationDemo extends App {
  val queue1 = new BasicIntQueue with Doubling with Filtering with Incrementing
  queue1.put(-1)
  queue1.put(0)
  queue1.put(1)
  println(queue1.get(), queue1.get(), queue1.get())

  val queue2 = new BasicIntQueue with Doubling with Incrementing with Filtering
  queue2.put(-1)
  queue2.put(0)
  queue2.put(1)
  println(queue2.get(), queue2.get())
}
