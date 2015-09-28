import org.apache.spark.SparkContext
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read
import org.apache.spark.SparkConf
import org.slf4j.LoggerFactory

object PlistaText {
  var count = 0
  val log = LoggerFactory.getLogger("PlistaText")
  
  def main(args: Array[String]): Unit = {
    // val mapper = new ObjectMapper() with ScalaObjectMapper
    val startTime = System.nanoTime()
    //val conf = new SparkConf().setAppName("PlistaText").setMaster("local")
    val sc = new SparkContext("local", "PlistaText")
    //val itemRDD = sc.textFile(Config.resourcesPath+"/2014-07-01.items")
    //val path = "/home/terciojorge/Downloads/2014-07-01.data"
    val path = args(0)
    val itemRDD = sc.textFile(path)

    //val teste = itemRDD.collect();
    for (x <- itemRDD) {
      count = count + 1
    }
    sc.stop()
    val endTime = System.nanoTime()
    log.info("total time: " + (endTime - startTime) / 1000000000d)
    log.info("contador: " + count)
    

  }
}