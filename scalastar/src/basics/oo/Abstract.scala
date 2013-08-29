/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}

object Demo {
  val x = { println("initialing x"); "done" }
}

object DemoApp extends App {
  val a = Demo
  println("------------")
  println(a.x)
}

class Food
abstract class Animal2 {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
class Grass extends Food
class Cow extends Animal2 {
  type SuitableFood = Grass
  override def eat(food: Grass) {}
}