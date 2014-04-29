package novels.borges

import scala.util.Random

/**
 * @author dongjie.shi
 *
 */

case class Person(name: String) {
  def dream(): Person = this
}

case class Time(time: Long) {
  def alreadyExists(): Boolean = { System.nanoTime >= time }
}

case class Death()
case class Water() {
  def disappearIn(x: AnyRef): Unit = {}
}

case class World() {
  def getUgly(): World with Ugly = new World with Ugly
  def extinguish(): Unit = {}
}

trait Ugly

object borgesDemo extends App {
  //我梦见，在梦里我梦见了我自己
  val i = Person("borges")
  val iInADream = i dream ()
  (iInADream dream ()) == i

  //未来已经存在。
  implicit def now = System.nanoTime
  val future = Time(now + (Random nextLong))
  future alreadyExists

  //死就是水消失在水里.
  val death = Death()
  val water = Water()
  death == (water disappearIn water)

  //世界先是变丑 然后熄灭
  val world = World()
  ((world getUgly) extinguish)
}