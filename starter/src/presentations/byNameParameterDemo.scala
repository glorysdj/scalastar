/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object byNameParameterDemo extends App {
  def nano() = {
    println("Getting nano")
    System.nanoTime
  }

  def delayed(t: => Long) = { // => indicates a by-name parameter
    println("In delayed method")
    println("Param: " + t)
    t
  }

  println(delayed(nano()))
}