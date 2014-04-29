/**
 *
 */
package core.oo.objects

import scala.collection.mutable.Map

/**
 * @author dongjie.shi
 * this a example of companion object
 */
class ChecksumAccumulator(private val name: String) {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  //use case.1 apply as factory methods, also like a static method
  def applay(name: String) = new ChecksumAccumulator(name)
  //use case.2 unapply as extractors, also like a static method
  def unapply(str: String): Option[(String, String)] = { Some(str, str.reverse) }
  //use case.3 static field
  private val cache = Map[String, Int]()
  //use case.4 static method
  def calculate(s: String): Int =
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccumulator("hello")
      for (c <- s) {
        acc.add(c.toByte)
      }
      val cs = acc.checkSum
      cache += (s -> cs)
      cs
    }
}

object objectDemo extends App {
  println(ChecksumAccumulator.calculate("hello world"))
}