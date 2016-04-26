package core.fp

/**
 * @author dongjie.shi
 *
 */
object mapFilterReduceAndPar extends App {

  val unit = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "p", "ethan", "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack", "m", "michael")
  List.range(1, 100).map { i =>
    val employees = List.range(0, i * 10).map(_ => unit).flatten
    println(s"----------------------------------------------")
    val start = System.currentTimeMillis()
    val result = employees.filter(_.length > 1).map(_.capitalize).reduce(_ + "," + _)
    val end = System.currentTimeMillis()
    //println(s"result is: $result")
    println(s"spent ${end - start} millis")

    val start2 = System.currentTimeMillis()
    val result2 = employees.par.filter(_.length > 1).map(_.capitalize).reduce(_ + "," + _)
    val end2 = System.currentTimeMillis()
    //println(s"result is: $result2")
    println(s"par spent ${end2 - start2} millis")
  }
}