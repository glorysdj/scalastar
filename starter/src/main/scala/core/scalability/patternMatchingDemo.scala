package core.scalability

/**
 * @author dongjie.shi
 *
 */
object patternMatchingDemo extends App {

  def simplify(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplify(e)
    case BinOp("+", e, Number(0)) => simplify(e)
    case BinOp("*", e, Number(1)) => simplify(e)
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case UnOp(op, e) => UnOp(op, simplify(e))
    case BinOp(op, a, b) => BinOp(op, simplify(a), simplify(b))
    case _ => expr
  }
  println(simplify(UnOp("-", UnOp("-", Number(1.5)))))
  println(simplify(UnOp("-", UnOp("-", Var("x")))))

  val pi: Double = Math.E
  def find(x: Any) = x match {
    case Math.PI => x
    case "hello" => "exactly hello"
    case UnOp("-", UnOp("-", e @ Var(_))) => "a " + e
    case UnOp("-", UnOp("+", e)) => "b " + e
    case List(0, _, _) => "List 3 objs, starts with 0"
    case Array(0, 1, _*) => "Array starts with 0, 1"
    case (a, b, c) => "find " + a + b + c
    case s: String => s.length
    case m: Map[_, _] => m.size
    case a: Array[Int] => a.size
    case pi => pi
    case x if(true)=>pi
    //case _ => x
  }
  println(find(Math.PI), find(pi))
  println(find(UnOp("-", UnOp("+", Number(5)))), find(UnOp("-", UnOp("-", Var("x")))))
  println(find(List(0, 3, 6)), find(Array(0, 1)))
  println(find("a", 7, Nil))
  println(find("hello world"), find(Map("US" -> "Washington", "France" -> "Paris")), find(Array(1, 2, 3)))
}

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr