/**
 *
 */
package presentations

import scala.collection.immutable.{ HashMap => ImmutableHashMap }
import scala.collection.mutable.{ HashMap => MutableHashMap }
import scala.util.Random
import java.util.concurrent.Executors

/**
 * @author dongjie.shi
 *
 */
object immutableDemo extends App {
  implicit def functionToCallable[A](f: () => A) = new Runnable {
    override def run() {
      f()
    }
  }
  
  var executor = Executors.newFixedThreadPool(2)

  val mutableService = new MutableService[Int, Int]
  val f = () => {
    mutableService.insert(Random.nextInt(100), Random.nextInt(100))
  }
  val g = () => {
    mutableService.lookUp(Random.nextInt(100))
  }

  val immutableService = new ImmutableService[Int, Int]
  val f2 = () => {
    immutableService.insert(Random.nextInt(100), Random.nextInt(100))
  }
  val g2 = () => {
    immutableService.lookUp(Random.nextInt(100))
  }

  val times = List(50)
  times.foreach(x => {

    val begin = System.nanoTime
    
    List.range(0, x).foreach(_ => executor.execute(f))
    List.range(0, x).foreach(_ => executor.execute(g))
    val end = System.nanoTime
    println(x, end - begin)

    val begin2 = System.nanoTime
    List.range(0, x).foreach(_ => executor.execute(f2))
    List.range(0, x).foreach(_ => executor.execute(g2))
    val end2 = System.nanoTime
    println(x, end2 - begin2)

    println(x, (end2 - begin2) * 1.0 / (end - begin) * 100 + "%")
  })

}

trait Service[Key, Value] {
  def lookUp(k: Key): Option[Value]
  def insert(k: Key, v: Value): Unit
}
class MutableService[Key, Value] extends Service[Key, Value] {
  val currentIndex = new MutableHashMap[Key, Value]
  def lookUp(k: Key): Option[Value] = synchronized(currentIndex.get(k))
  def insert(k: Key, v: Value): Unit = synchronized {
    currentIndex.put(k, v)
  }
}
class ImmutableService[Key, Value] extends Service[Key, Value] {
  var currentIndex = new ImmutableHashMap[Key, Value]
  def lookUp(k: Key): Option[Value] = currentIndex.get(k)
  def insert(k: Key, v: Value): Unit = synchronized {
    currentIndex = currentIndex + ((k, v))
  }
}