package core.oo.classes

/**
 * @author dongjie.shi
 *
 * this is a example of sealed and case class
 * 1. factory method: no new need
 * 2. all arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained as fields
 * 3. the compiler adds “natural” implementations of methods toString, hashCode, and equals to your class
 * 4. the compiler adds a copy method to your class for making modified copies.
 */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object caseClassDemo extends App {
  val a = Var("x")
  val b = BinOp("+", Var("x"), UnOp("-", Number(1.5)))
  println(b.left, b.right)
  println(a, b, a == Var("x"), a.##)
  println(b.copy(operator = "-"))
}