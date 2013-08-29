/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object sets_maps extends App {
  var capitals = Map("US" -> "Washington", "France" -> "Paris")
  capitals += ("Japan" -> "Tokyo")
  println(capitals)
  println(capitals("France"))
  println(capitals get "France")
  //println(capitals("China")) //java.util.NoSuchElementException: key not found: China
  println(capitals get "China")

  var set = Set("hello", "world")
  set += "scala"
  println(set)
}