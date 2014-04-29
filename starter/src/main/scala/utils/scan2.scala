/**
 *
 */
package utils

import java.io.File
import scala.io.Source
import java.util.jar.JarFile
import java.util.Scanner
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.InputStream

/**
 * @author dongjie.shi
 *
 */
object scan2 extends App {

  def process(f: File, x:String, func: (File, String) => Unit) {
    f.isDirectory() match {
      case true => {
        val files = f.listFiles()
        files.foreach(process(_, x, func))
      }
      case false => {
        func(f, x)
      }
    }
  }

  val search = (f: File, x: String) => {
    println(f)
    val source = Source.fromFile(f)
    if(source.getLines.exists(_.contains(x))){
      println("!!!!!!!!!!!!!!!!!!!!!!")
    }
  }

  val source = new File("C:/ODM801/WAS/AppServer/profiles/ODMSample8010/installedApps/SamplesCell/teamserver-WAS8.ear")
  val key = "priority ext"
  process(source, key, search)
}