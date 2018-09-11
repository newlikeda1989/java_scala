package com.dataflowdeveloper.example

import org.apache.spark.sql.SparkSession

class Example {
  def run(spark: SparkSession) {
    try {
      println("Started")
      val shdf = spark.read.parquet("hdfs://hw61.xgate.com:8020/nifi/comvita/mbr_transform/INT_XMEMBER_20180706_003000.parquet")
      shdf.printSchema()
      shdf.createOrReplaceTempView("smartplug")
      val stuffdf = spark.sql("SELECT * FROM smartplug")
      stuffdf.count()
      println("Complete.")
    } catch {
      case e: Exception =>
        e.printStackTrace();
    }
  }
}