/**
 *
 */
package fp

import java.io.File

/**
 * @author dongjie.shi
 *
 */
object firstClassFunctions extends App {
  val addOne = (x: Int) => x + 1
  val addTwo = (x: Int) => x + 2

  def addMany = (f: (Int => Int), x: Int) => f(x)

  println(addMany(addOne, 1))
  println(addMany(addTwo, 1))

  private def files = (new File(".")).listFiles()
  private def filesMactching(matcher: String => Boolean) =
    for (file <- files; if matcher(file.getName()))
      yield file

  def filesEnding(query: String) =
    filesMactching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMactching(_.contains(query))

  def filesRegex(query: String) =
    filesMactching(_.matches(query))
}