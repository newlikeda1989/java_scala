package com.app.test
import org.apache.spark.sql.SparkSession

class MyTest {
  def run(spark: SparkSession) {
    try {
      println("Started22")
      val shdf = spark.read.parquet("hdfs://hw61.xgate.com:8020/nifi/comvita/mbr_transform/INT_XMEMBER_20180706_003000.parquet")
      shdf.printSchema()
      shdf.createOrReplaceTempView("smartplug")
      val stuffdf = spark.sql("SELECT * FROM smartplug")
      stuffdf.count()
      println("Complete33.")
    } catch {
      case e: Exception =>
        e.printStackTrace();
    }
  }
}