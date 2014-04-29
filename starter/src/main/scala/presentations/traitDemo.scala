/**
 *
 */
package presentations

import scala.collection.mutable

/**
 * @author dongjie.shi
 *
 */
object traitDemo extends App {
  val frog = new Frog
  frog.philosophize()
  val fox = new Animal with Philosophical {
    override def philosophize() {getQuestions.foreach(println)}
  }
  fox.addQuestion("who am i")
  fox.addQuestion("where am i from")
  fox.philosophize()
  
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

trait Philosophical {
  private var questions: List[String] = Nil
  def addQuestion(question: String) { questions = question :: questions }
  def getQuestions = questions
  def philosophize() { println("I consume memory, therefore I am!") }
}
trait HasLegs
class Animal

class Frog extends Animal with HasLegs with Philosophical {
  override def toString = "green"
}

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new mutable.ArrayBuffer[Int]
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