package gui

import scala.swing.SimpleSwingApplication
import scala.swing.MainFrame

/**
 * @author dongjie.shi
 *
 */
case class Point(x: Double, y: Double)
case class Rectangle(northWest: Point, southEast: Point)