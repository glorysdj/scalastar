/**
 *
 */
package basics

/**
 * @author dongjie.shi
 *
 */
object sets extends App {
  val nums = Set(1, 2, 3)
  println(nums)

  println(nums + 5)
  println(nums - 3)
  println(nums ++ List(1, 6))
  println(nums -- List(1, 6))

  println(nums & Set(1, 6))

  println(nums.size)
  println(nums contains 3)

  import scala.collection.mutable.Set
  val words = Set("hello", "scala")
  println(words)
  println(words += "world")
  println(words -= "hello")
  println(words ++= List("do", "your"))
  println(words --= List("do", "your"))
  println(words.clear())
}