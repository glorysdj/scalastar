/**
 *
 */
package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object Test3 extends App {

  def solution(K: Int, A: Array[Int]): Int = {
    val set = A.toSet
    val map = set.map(i => (i, A.count(_ == i))).toMap
    val bus = A.map(K - _)
    val counts = bus.map(map.getOrElse(_, 0))
    counts.sum
  }
  
  println(solution(6, Array(1, 8, -3, 0, 1, 3, -2, 4, 5)))
}