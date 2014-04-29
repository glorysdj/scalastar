/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean = true, private val age: Int) extends Cat

object CatDriver extends App {
  val cat = new Cat
  val tiger = new Tiger(true, 5)
  
  import tiger._
  println(dangerous)
  //println(age)
  
  println(cat.isInstanceOf[Cat], tiger.isInstanceOf[Cat], tiger.isInstanceOf[Tiger])
}