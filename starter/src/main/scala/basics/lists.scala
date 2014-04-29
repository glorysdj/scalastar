package basics

/**
 * @author dongjie.shi
 *
 */
object lists extends App {
  println("---------list")
  val list = List(1, 2, 3, 4, 5)
  println(list)
  println(List.apply(1,2,3,4,5))
  println(List.range(1, 5))
  println(List.range(1, 5, 2))
  println(List.range(9, 5, -2))
  //println(List.make(6, "hello"))

  println("---------:: & :::, ++ & ++:")
  println(0 :: List(1, 2, 3) ::: List(6))
  println(List(1, 2, 3) ++ List(6))
  println(List(1, 2, 3) ++: List(6))
  
  println("---------size & length, apply and (index)")
  println(list.size, list.length)
  println(list apply 2, list(2))

  println("---------head, last, init, tail, reverse")
  println(list.head)
  println(list.tail)
  println(list.init)
  println(list.last)
  println(list.reverse)
  
  println("---------take, drop, splitAt")
  println(list take 2)
  println(list drop 2)
  println(list splitAt 2)
  
  println("---------indices, zipWithIndex, zip")
  println(list.indices)
  println(list.zipWithIndex)
  println(list.zip(List("a", "b", "c", "d")))

  println("---------max , min & sum")
  println(list.max)
  println(list.min)
  println(list.sum)

  println("---------string: addString, mkString, stringPrefix")
  println(list.addString(new StringBuilder()))
  println(list.addString(new StringBuilder(), "#"))
  println(list.addString(new StringBuilder(), "(", "#", ")"))
  println(list.mkString)
  println(list.mkString("#"))
  println(list.mkString("(", "#", ")"))
  println(list.stringPrefix)

  println("---------reverse, drop, slice, split, span & take")
  println(list.reverse)
  println(list.drop(1))
  println(list.dropWhile(_ == 1))
  println(list.slice(2, 4))
  println(list.splitAt(3))
  println(list.span(_ > 0))
  println(list.take(4))

  val words = "hello" :: "scala" :: "world" :: "haha" :: Nil

  println("---------exists, count, find")
  println(words.exists(_.length == 4))
  println(words.count(_.length == 5))
  println(words.find(_.length == 5))

  println("---------map, reduce, filter")
  println(words.map(_ + "_"))
  println(words.reduce(_ + _))
  println(words.filter(_.length == 5))

  println("---------/: & :\\ folder & scan")
  println(list)
  println(list./:(5)(_ - _))
  println(list.:\(5)(_ - _))
  println(list.fold(5)(_ - _))
  println(list.foldLeft(5)(_ - _))
  println(list.foldRight(5)(_ - _))
  println(list.scan(5)(_ - _))
  println(list.scanLeft(5)(_ - _))
  println(list.scanRight(5)(_ - _))

  println("---------collect and partition")
  println(list collect { case x if x % 2 == 0 => -x; case x => x })
  println(list.partition(_ > 3))

  println("---------flatMap & flatten")
  println(list.flatMap(x => List(x - 1, x, x + 1)))
  println(List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), List(3, 4, 5), List(4, 5, 6)).flatten)
}