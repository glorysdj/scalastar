/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class Thermometer {
  var celsius: Float = _
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= (f: Float) { celsius = (f - 32) * 5 / 9}
  override def toString = fahrenheit + "F/" + celsius + "C"
}

object ThermometerApp extends App{
  val t = new Thermometer
  println(t)
  t.fahrenheit = 64
  println(t)
}