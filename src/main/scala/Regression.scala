import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.Vectors

object Regression {
  def main(args: Array[String]): Unit = {    
      val sc = new SparkContext("local", "LinearReegression")
      
      val data = sc.textFile(Config.resourcesPath + "lpsa.data")
      val parsedData = data.map { line =>
        val parts = line.split(',')
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
      }.cache()
      
      // Building the model
      val numIterations = 100
      val model = LinearRegressionWithSGD.train(parsedData, numIterations)
      
      // Evaluate model on training examples and compute training error
      val valuesAndPreds = parsedData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
      }
      val MSE = valuesAndPreds.map{case(v, p) => math.pow((v - p), 2)}.mean()
          println("training Mean Squared Error = " + MSE)
  }
}
