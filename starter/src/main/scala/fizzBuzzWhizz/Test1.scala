/**
 *
 */
package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object Test1 extends App {

  def solution(S: String): Int = {
    val chars = 'a' to 'z'
    val counts = chars.map(c => S.count(_ == c))
    //counts.foreach(println)
    val odds = counts.filter(_ % 2 != 0)
    odds.foreach(println)
    val count = odds.size
    if (count > 1) {
      0
    } else {
      1
    }
  }

  //println(solution("kayak"))
  //println(solution("kayyyak"))
  println(solution("dooernedeevrvn"))
  
}