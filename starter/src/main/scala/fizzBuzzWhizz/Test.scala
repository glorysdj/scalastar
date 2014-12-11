/**
 *
 */
package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object Test extends App {

  def solution(A: Array[Int]): Int = {
    val sum = A.sum
    var index = -1
    for (i <- 1 to A.length - 1) {
      val left = A.take(i).sum
      val right = sum - A(i) - left
      if(left == right){
        index = i
      }
    }
    index
  }

  println(solution(Array(-7, 1, 5, 2, -4, 3, 0)))
}