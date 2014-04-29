/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object optionDemo extends App {
  println("basics")
  val x: Option[String] = None
  //println(x.get)
  println(x.getOrElse("default"))
  val y = Some("now initialized")
  println(y.get)
  println(y.getOrElse("default"))

  println("\noption factory")
  val a = Option(null)
  val b = Option("hello")
  println(a.getOrElse("default"), b.get)

  println("\nCREATE AN OBJECT OR RETURN A DEFAULT")
  def getTemporaryDirectory(tmpArg: Option[String]): java.io.File = {
    tmpArg.map(name => new java.io.File(name)).filter(_.isDirectory).getOrElse(new java.io.File(System.getProperty("java.io.tmpdir")))
  }
  println(getTemporaryDirectory(None))
  println(getTemporaryDirectory(Option("hello")))
  println(getTemporaryDirectory(Option("c:\\temp")))

  println("\nEXECUTE BLOCK OF CODE IF VARIABLE IS INITIALIZED")
  def printname(username: Option[String]) {
    for (uname <- username) {
      println("User: " + uname)
    }
  }
  printname(Option(null))
  printname(Option("glorysdj"))

  def compareTwoNum(no1: Option[Int], no2: Option[Int]) = {
    for (n1 <- no1; n2 <- no2) {
      if (n1 > n2) println("bigger")
      else if (n1 == n2) println("equals")
      else println("smaller")
    }
  }
  compareTwoNum(Option(1), None)
  compareTwoNum(None, Option(2))
  compareTwoNum(Option(3), Option(2))

}