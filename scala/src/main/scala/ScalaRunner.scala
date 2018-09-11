import com.app.service.BooksProcessor
import com.app.storage.BookStorage

import com.app.test.MyTest

import org.apache.spark.sql.SparkSession

object ScalaRunner extends App {

  implicit val books = (new BookStorage()).getBooks
  BooksProcessor.filterByAuthor("Jack London").foreach(b => println(b))
  
  println("ab")
  val spark = SparkSession
    .builder().master("local")
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  import spark.implicits._

  println("Before run11")
  val job = new MyTest()
  job.run(spark)
  println("After run22")
}