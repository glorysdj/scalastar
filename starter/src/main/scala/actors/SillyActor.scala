/**
 *
 */
package actors

import scala.actors.Actor

/**
 * @author dongjie.shi
 *
 */
object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 10) {
      println("I'm acting")
      Thread.sleep(1000)
    }
  }
}

object SeriousActor extends Actor {
  def act() {
    for (i <- 1 to 10) {
      println("To be or not to be")
      Thread.sleep(1000)
    }
  }
}

object EchoActor extends Actor {
  def act() {
    while (true) {
    }
  }
}

object ActorsApp extends App {
  SillyActor.start()
  SeriousActor.start()
}