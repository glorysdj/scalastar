/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object arrays extends App {
  val greetStrings = new Array[String](3)
  greetStrings(0) = "hello"
  greetStrings(1) = "world"
  greetStrings(2) = "scala"
  println(greetStrings)
  
  greetStrings.foreach(println)
  
  val names = Array("one", "two", "three")
  names.foreach(println)
}