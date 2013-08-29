/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
object ColorEnum extends Enumeration {
  val Red, Green, Blue = Value
}

object DirectionEnum extends Enumeration {
  val North, East, South, West = Value
}

object EnumApp extends App {
  ColorEnum.values.foreach(println(_))
  for (d <- DirectionEnum.values) {
    println(d + " " + d.id)
  }
}