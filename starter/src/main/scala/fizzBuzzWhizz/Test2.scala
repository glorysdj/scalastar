/**
 *
 */
package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object Test2 extends App {

  def solution(A: Array[Int]): Int = {
    var max = 0
    var min = 100000
    val maxes = A.map(i => {
      if (i > max) {
        max = i
      }
      max
    })
    val mins = A.reverse.map(i => {
      if (i < min) {
        min = i
      }
      min
    }).reverse
    println(maxes.toList)
    println(mins.toList)
    for (i <- 0 to A.length -1) {
      if(A(i)>=maxes(i) && A(i)<=mins(i)){
        return i
      }
    }
    -1
  }

  println(solution(Array(4, 2, 2, 3, 1, 4, 7, 8, 6, 9)))

}