package basics

import java.io.File

/**
 * @author dongjie.shi
 *
 */
object controls extends App {
  //while
  var i = 0
  while (i < 5) {
    println(i)
    i += 1
  }

  //for/foreach
  val greetStrings = new Array[String](3)
  greetStrings(0) = "hello"
  greetStrings(1) = "world"
  greetStrings(2) = "scala"
  greetStrings.foreach(arg => println(arg))
  greetStrings.foreach(println(_))
  greetStrings.foreach(println)

  for (i <- 1 to 4 if i % 2 == 0)
    println(i)

  val files = (new File("./src/basics")).listFiles()
  def scalaFiles = for { file <- files if file.getName.endsWith(".scala") } yield file
  scalaFiles.foreach(println)
  def scalaFiles2 = for (file <- files if file.getName.endsWith(".scala")) yield file
  scalaFiles2.foreach(println)

  val args2 = Array("hello", "scala", "world", "sdfsfd")
  for (i <- 0 to 2) {
    args2(i) match {
      case "hello" => println("olleh")
      case "scala" => println("yes")
      case "world" => println("china")
      case _ => println("wtf")
    }
  }

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length())
      padding + prod
    }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10) yield makeRow(row)
    tableSeq.mkString("\n")
  }

  println(multiTable)

  //for()
  case class Book(title: String, authors: String*)
  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"),
      Book(
        "Programming in Modula2",
        "Wirth, Niklaus"),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"),
      Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gilad"))

  println(for (b <- books; a <- b.authors if a startsWith "Gosling") yield b)
  println(for (b <- books; if b.title.indexOf("Program")>=0)  yield b)
  println(for (b1 <- books; b2 <- books; if b1 != b2; a1<-b1.authors; a2<-b2.authors if a1==a2)  yield a1)
}