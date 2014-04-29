package core.scalability

/**
 * @author dongjie.shi
 *
 */
object optionDemo extends App {
  var capitals = Map("US" -> "Washington", "France" -> "Paris")
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  println(show(capitals get "US"))
  println(show(capitals get "CN"))
}