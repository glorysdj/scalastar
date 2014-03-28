/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object traitDemo2 extends App {
  val cat = new Cat
  println(cat.getClass)
  println(cat.isInstanceOf[Cat])
  println(cat.isInstanceOf[Animal2])
  println(cat.isInstanceOf[Furry2])
  println(cat.isInstanceOf[HasLegs2])
  println(cat.isInstanceOf[FourLegged2])
}

class Animal2
trait Furry2 extends Animal2
trait HasLegs2 extends Animal2
trait FourLegged2 extends HasLegs2
class Cat extends Animal2 with Furry2 with FourLegged2