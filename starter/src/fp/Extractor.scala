/**
 *
 */
package fp

/**
 * @author dongjie.shi
 *
 */
object Email {
  def apply(user: String, domain: String) = user + "@" + domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else
      None
  }
}

object Twice {
  def apply(s: String) = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (s == half * 2) Some(half) else None
  }
}
object Extractor extends App {
  println(Email.unapply("asfs@asfs.com"))
  println(Email.unapply("asfsasfs.com"))
  println(Twice.unapply("abcdabcd"))
  println(Twice.unapply("abcdeabcd"))
}