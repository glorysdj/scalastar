package basics

/**
 * @author dongjie.shi
 *
 */
object variables extends App {
  val a: Int = 6
  println(a)
  //a = 7
  var b = "Hello World"
  println(b)
  b = "Hello Scala"
  println(b)

  val s = "safsd.sf.sdf.sdf"
  val index = s.indexOf('.')
  println(index)
  println(s.substring(0, index), s.substring(index + 1))
  println(s.substring(0, s.size-3))
}