package core.fp

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

  def delayed2(t: () => Long) = {
    println("In delayed2 method")
    println("Param: " + t())
    t()
  }

  println(delayed(nano()))
  println(delayed2(nano))

}