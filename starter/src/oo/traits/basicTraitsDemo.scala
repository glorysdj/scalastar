/**
 *
 */
package oo.traits

/**
 * @author donshi
 *
 * this a basic example
 */
trait Philosophical {
  private var qs: List[String] = Nil
  def addQuestion(question: String) { qs = question :: questions }
  def questions = qs
  def philosophize() { println("I consume memory, therefore I am!") }
}

trait HasLegs

class Animal

class Frog extends Animal with HasLegs with Philosophical {
  override def toString = "green"
}

object basicTraitsDemo extends App {
  val frog = new Frog
  frog.philosophize
  
  val fox = new Animal with Philosophical {
    override def philosophize() {questions.foreach(println)}
  }
  fox.addQuestion("who am i")
  fox.philosophize

}