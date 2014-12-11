/**
 *
 */
package fizzBuzzWhizz

/**
 * @author dongjie.shi
 *
 */
object TestEditD {

  def distance(x: String, y: String): Boolean = {
    val xlength = x.length
    val ylength = y.length
    val lengthDiff = Math.abs(xlength - ylength)

    if (lengthDiff >= 2) {
      false
    } else if (Math.abs(xlength - xlength) == 1) {
      //case Removal &  Insert
      if (x.contains(y) || y.contains(x)) {
        //case Removal
        true
      } else {
        //case Insert
        //TODO
        abcdef abef
        0123
        23
        
        false
      }

    } else {
      //case Modiciation
      val distance = List.range(0, xlength).map(i => {
        x.charAt(i) != y.charAt(i)
      }).filter(_ == true).size
      if (distance <= 1) {
        true
      } else {
        false
      }
    }
  }

}