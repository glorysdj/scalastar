package basics.oo

import scala.collection.mutable.ArrayBuffer

/**
 * @author dongjie.shi
 *
 */
trait Philosophical {
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

class Animal
trait HasLegs

class Frog extends Animal with HasLegs with Philosophical {
  override def toString = "green"
}

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

object TraitsApp extends App {
  val frog = new Frog
  frog.philosophize()
  println(frog)

  val queue1 = new BasicIntQueue with Doubling with Incrementing with Filtering
  queue1.put(-1)
  queue1.put(0)
  queue1.put(1)
  println(queue1.get(), queue1.get())

  val queue2 = new BasicIntQueue with Doubling with Filtering with Incrementing
  queue2.put(-1)
  queue2.put(0)
  queue2.put(1)
  println(queue2.get(), queue2.get(), queue2.get())
}