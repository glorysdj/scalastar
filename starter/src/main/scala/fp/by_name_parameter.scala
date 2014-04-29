/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object by_name_parameter extends App {
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