/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object tuples extends App {
  val tuple = (1, "hello", List(2, 3))
  println(tuple)
  
  def getReturn() = (1, "hello", Console)
  println(getReturn._1)
  println(getReturn._2)
  println(getReturn._3)
}