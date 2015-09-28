import org.apache.spark.SparkContext
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read
import org.apache.spark.SparkConf
import org.slf4j.LoggerFactory

object PlistaJsonJson4s {
  var count = 0
  val log = LoggerFactory.getLogger("PlistaJsonJson4s")
  
  def main(args: Array[String]): Unit = {
    // val mapper = new ObjectMapper() with ScalaObjectMapper
    val startTime = System.nanoTime()
    //val conf = new SparkConf().setAppName("PlistaJson4S")
    val sc = new SparkContext("local", "PlistaJson4S")
    val path = args(0)
    //val path = Config.resourcesPath+"/2014-07-01.items"
    val itemRDD = sc.textFile(path)
    /*val teste = itemRDD.take(10)
       for(x <- teste){
         println(x)
       }*/
    val itemJson = itemRDD.map({ record =>
      implicit val format = DefaultFormats
      read[Data](record)
    })
    for (item <- itemJson) {
      //println(item.domainid)
      count = count + 1
    }
    //println(itemJson.count())
    sc.stop()
    val endTime = System.nanoTime()
    log.info("total time: " + (endTime - startTime) / 1000000000d)
    log.info("contador: " + count)

  }
}