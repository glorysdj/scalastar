/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class MyClass (index: Int, name: String) {
}

object Driver extends App{
  val aMyClass = new MyClass(5, "hello")
  println(aMyClass)
}
