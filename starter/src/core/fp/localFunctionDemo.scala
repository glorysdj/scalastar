package core.fp

import scala.io.Source

/**
 * @author dongjie.shi
 *
 */
object localFunctionDemo extends App {
  def processFile(fileName: String) = {
    //local function
    def processLine(line: String) = line.length + ": " + line
    val source = Source.fromFile(fileName)
    for (line <- source.getLines) yield processLine(line)
  }
  processFile("./src/basics/lists.scala").foreach(println)
}