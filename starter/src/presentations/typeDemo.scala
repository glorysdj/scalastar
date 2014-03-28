/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object TypeDemo extends App {
  println("val and var")
  val a: Int = 6
  var b: String = "hello scala"
  println(a, b)
  //a = 7
  b = "hello world"
  println(a, b)

  println("\nval znad lazy val")
  val x = new X
  val y = new Y
  println("x,y are initialized")
  println(x.value, y.value)
  
  println("\nType inference")
  val names = Array("one", "two", "three")
  val c = 1 + 2.5
  println(names.getClass, c.getClass)
  
  println("\nDropping verbose syntax")
  x sayHello;
  x sayHelloTo "Alex"
  y :: x
}

class X {
  val value = { println("x initializing value"); "my name is X" }
  def sayHello() = {
    println("hello hi haloha")
  }
  def sayHelloTo(who : String) = {
    println("hello " + who) 
  }
  def ::(who: Y) = {
    println("hello " + who.value) 
  }
}
class Y {
  lazy val value = { println("y initializing value"); "my name is Y" }
}