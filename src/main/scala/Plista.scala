import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import java.io.PrintWriter
import scala.reflect.io.File
import org.slf4j.LoggerFactory



object Plista {

  var count = 0
  val log = LoggerFactory.getLogger("Plista")

  def main(args: Array[String]): Unit = {

    //val conf = new SparkConf().setAppName("PlistaSqlContext")
    

    val startTime = System.nanoTime()
    val sc = new SparkContext("local", "PlistaSqlContext")
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    // A JSON dataset is pointed to by path.
    // The path can be either a single text file or a directory storing text files.
    //val path = "/home/terciojorge/Downloads/2014-07-01.data"
    //val path = Config.resourcesPath+"/2014-07-01.items"
    // Create a DataFrame from the file(s) pointed to by path
    val input = args(0)
    //val output = args(1)
    
    val news = sqlContext.jsonFile(input)

    //news.printSchema()

    news.registerTempTable("news")

    val texts = sqlContext.sql("SELECT domainid FROM news")

    for (x <- texts) {

      count = count + 1
      //println(count)  

    }
    
    sc.stop()
    val endTime = System.nanoTime()
    log.info("total time: " + (endTime - startTime) / 1000000000d)
    log.info("contador: " + count)
    
  }

}