/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object misc extends App {
  val name = "saffjdsl;SFDsgdgsdg"
  println(name.exists(_.isUpper))
  
  def echo(args: String*) {
    args.foreach(println)
  }
  
  echo("one", "two")
  
  val arr = Array("1", "2", "3")
  echo(arr:_*)
}