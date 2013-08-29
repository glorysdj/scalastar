/**
 *
 */
package basics.oo

import scala.collection.mutable.Map

/**
 * @author dongjie.shi
 *
 */
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator extends App {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccumulator
      for (c <- s) {
        acc.add(c.toByte)
      }
      val cs = acc.checkSum
      cache += (s -> cs)
      cs
    }
  
    println(ChecksumAccumulator.calculate("hello world"))
}