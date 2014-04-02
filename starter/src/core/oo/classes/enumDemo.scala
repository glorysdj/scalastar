/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
object DirectionEnum extends Enumeration {
  val North, East, South, West = Value
}

object enumDemo extends App {
  for (d <- DirectionEnum.values) {
    println(d + " " + d.id)
  }
}