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
object scan extends App {
  //val files = (new File("C:/Users/donshi/Desktop/DC/jrules-paypal-teamserver-WAS8/decisioncenter/WEB-INF/lib/")).listFiles()
  //val files = (new File("C:/Users/donshi/Desktop/DC/jrules-paypal-teamserver-WAS8/teamserver/WEB-INF/lib/")).listFiles()
  val files = (new File("C:/ODM801/WAS/AppServer/profiles/ODMSample8010/installedApps/SamplesCell/teamserver-WAS8.ear/teamserver.war/WEB-INF/lib")).listFiles()
  //val files = (new File("C:/ODM801/WAS/AppServer/profiles/ODMSample8010/installedApps/SamplesCell/teamserver-WAS8.ear/decisioncenter.war/WEB-INF/lib")).listFiles()
  for (f <- files) {
    //println(f)
    val jar = new JarFile(f)
    val enu = jar.entries
    while (enu.hasMoreElements) {
      val entry = enu.nextElement
      val istream = jar.getInputStream(entry)
      val inputStringBuilder = new StringBuilder()
      val bufferedReader = new BufferedReader(new InputStreamReader(istream, "UTF-8"))
      var line = bufferedReader.readLine()
      while (line != null) {
        inputStringBuilder.append(line); inputStringBuilder.append('\n')
        line = bufferedReader.readLine()
      }
      //println(inputStringBuilder)
      val content = inputStringBuilder.toString
      if(content.contains("markElementModified")){
        println("============================"+f)
        println(entry)
        //println(content)
      }
      istream.close
    }
  }
}