package core.scalability

/**
 * @author dongjie.shi
 *
 */
class EMail(user: String, domain: String) {
}

object EMail {
  def apply(user: String, domain: String) = user + "@" + domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}

object extractorDemo extends App {
  val str = EMail("glorysdj", "gmail.com")
  str match{
    case EMail(user, domain) => println(user, domain)
  }
}