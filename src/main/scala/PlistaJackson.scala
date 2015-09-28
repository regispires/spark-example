import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.slf4j.LoggerFactory

object PlistaJackson {
  var count = 0
  val log = LoggerFactory.getLogger("PlistaJackson")

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
    //println(itemRDD.first)

    /*try {
        println("Teste")
      } catch {
        case e: Exception =>{
          println("exception caught: "+e)
          }
        
        
      }
    */
    val result = itemRDD.flatMap(record => {

      Some(mapper.readValue(record, classOf[DataJackson]))

    })
    //println(result.first());
    /*val listaItem = result.collect()
    for( x <- listaItem){
      println(x.title)
    }*/
    for (item <- result) {
      //println(item.domainid)

      count = count + 1
    }

    sc.stop()
    val endTime = System.nanoTime()
    log.info("total time: " + (endTime - startTime) / 1000000000d)
    log.info("contador: " + count)

  }
}