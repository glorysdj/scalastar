/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class Point(val x: Int, val y: Int) {
  override def toString = "(" + x + "," + y + ")"
}

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  override def toString = topLeft + "--" + bottomRight
}

object GeometryApp extends App {
  val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
  println(rect)
}