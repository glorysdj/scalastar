/**
 *
 */
package basics

import scala.collection.immutable.TreeSet

/**
 * @author dongjie.shi
 *
 */
object maps extends App {
  val nums = Map("i" -> 1, "ii" -> 2)
  println(nums)
  println(nums + ("ii" -> 333))
  println(nums.size)
  println(nums.contains("iv"))
  println(nums.keySet)
  println(nums.values)
  println(nums + ("iii" -> 3))
  println(nums - ("i"))
  println(nums ++ List("iii" -> 3, "iv" -> 4))
  println(nums -- List("i", "iv"))
  
  for(key <- nums.keySet){
    println(key, nums(key), nums.keySet.toSeq.indexOf(key))
  }

  import scala.collection.mutable.Map
  val words = Map.empty[String, Int]
  println(words += "one" -> 1)
  println(words -= "one")
  println(words ++= List("iii" -> 3, "iv" -> 4))
  println(words --= List("iii", "v"))

  val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
  println(ts)
}