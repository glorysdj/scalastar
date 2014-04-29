/**
 *
 */
package presentations

/**
 * @author dongjie.shi
 *
 */
object lazyFibonacciDemo extends App {

  lazy val fib1: Stream[Long] = 0 #:: 1 #:: fib1.zip(fib1.tail).map { n => println(fib1.tail, n, n._1, n._2); n._1 + n._2 }

  def fib2: Stream[Long] = {
    def fibInner(f0: Long, f1: Long): Stream[Long] = {
      Stream.cons(f0, fibInner(f1, f0 + f1))
    }
    fibInner(0, 1)
  }

  println("0:" + fib1(0))
  println("1:" + fib1(1))
  println("6:" + fib1(6))
  //println(fib2(0), fib2(1), fib2(10))

  fib1 take 11 foreach println
}