/**
 *
 */
package core.fp

/**
 * @author donshi
 *
 */
object compose_andThenDemo extends App {

  def f(s: String) = "f(" + s + ")"
  def g(s: String) = "g(" + s + ")"
  
  val fg = f _ compose g _
  println(fg("_yay_"))
  
  val gf = f _ andThen g _
  println(gf("_yay_"))
  
}