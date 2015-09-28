import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import scala.io.Source 

object WordCount {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local", "WordCount")
    // Load our input data.
    val source = Config.resourcesPath + "/test.txt"
    println("source: " + source)
    val input = sc.textFile(source)
    // Split it up into words.
    val words = input.flatMap(line => line.split(" "))
    // Transform into word and count.
    val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y} 
    // Save the word count back out to a text file, causing evaluation. 
    counts.saveAsTextFile(Config.home + "scala-output") 
  }
}
