import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.apache.spark.SparkContext
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory

object PlistaTree {
  var count = 0
  val log = LoggerFactory.getLogger("PlistaTree")
  
  def main(args: Array[String]): Unit = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    /*val mapper = new ObjectMapper()*/
    //mapper.registerModule(DefaultScalaModule)
    val startTime = System.nanoTime()
   // val conf = new SparkConf().setAppName("PlistaJackson")
    val sc = new SparkContext("local","PlistaJackson")
    //val sc = new SparkContext("local", "Jackson")
    //val path = Config.resourcesPath+"/2014-07-01.items"
    val path = args(0)
    val itemRDD = sc.textFile(path)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
    
    for(x <- itemRDD){
      var node = mapper.readTree(x)
      //println(node.path("event_type")
      count = count + 1
    }
    sc.stop()
    val endTime = System.nanoTime()
    log.info("total time: " + (endTime - startTime) / 1000000000d)
    log.info("contador: " + count)

    
   /* val result = itemRDD.flatMap(record => {

      Some(mapper.readTree(record))

    })
    */
    //result.first().path("event_type")
    
    
  }
    
    
}