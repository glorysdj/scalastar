package basics

object regex extends App {

  val line = "hello world! and you:james is not a clever--one!!!"

  val words = line.split("\\W")
  words.foreach(println)
}