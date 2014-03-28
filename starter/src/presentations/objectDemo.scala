/**
 *
 */
package presentations

import scala.collection.mutable

/**
 * @author dongjie.shi
 *
 */
object objectDemo extends App {
  println(ChecksumAccumulator.calculate("hello world"))
}

class ChecksumAccumulator(private val name: String) {
  private var extraData = ""
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  def apply(name:String) = new ChecksumAccumulator(name) 
  private val cache = mutable.Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = ChecksumAccumulator("hello")
      for (c <- s) { acc.add(c.toByte) }
      val cs = acc.checkSum
      cache += (s -> cs)
      cs
    }
}