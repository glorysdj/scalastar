/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    override def toString = amount + " " + designation
    def +(that: Currency): Currency = make(this.amount + that.amount)
    def *(x: Double): Currency = make((this.amount * x).toLong)
  }
}

object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }
  type Currency = Dollar
  def make(x: Long): Currency = new Dollar {
    val amount = x
  }
  val Cent = make(1)
  val Dollar = make(100)
  val Unit = Dollar
}