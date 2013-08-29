package basics

import scala.io.Source

/**
 * @author dongjie.shi
 *
 */
object files extends App {
  Source.fromFile("C:/dev.6/eclipse/workspace/scalastar/src/basics/lists.scala").getLines.foreach(println)
}