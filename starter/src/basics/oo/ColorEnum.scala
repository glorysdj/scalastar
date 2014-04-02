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

object EnumApp extends App {
  ColorEnum.values.foreach(println(_))
}