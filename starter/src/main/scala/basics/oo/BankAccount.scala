/**
 *
 */
package basics.oo

/**
 * @author dongjie.shi
 *
 */
class BankAccount {
  private var bal: Int = 0

  def balance: Int = bal

  def deposite(amount: Int) = {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean = {
    if (amount > bal) {
      false
    } else {
      bal -= amount
      true
    }
  }
}

object BankAccountApp extends App{
  val ba = new BankAccount
  println(ba.deposite(100))
  println(ba.withdraw(80))
  println(ba.withdraw(80))
}