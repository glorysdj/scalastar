/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object decorators extends App {
  //memory
  def memory(f: Int => Int) = new Function1[Int, Int] {
    var cache = Map[Int, Int]()
    def apply(i: Int) =
      if (cache contains i) {
        println("cache hit for " + i)
        cache(i)
      } else {
        println("calculate " + i)
        val ret = f(i)
        cache += (i -> ret)
        ret
      }
  }

  val fib: Int => Int = memory {
    case 0 => 0
    case 1 => 1
    case n => fib(n - 1) + fib(n - 2)
  }

  println(fib(10))

  //aop
  def aop(f: => Unit) = {
    println(f + " begin")
    f
    println(f + " end")
  }
  
  aop(fib(10))
}