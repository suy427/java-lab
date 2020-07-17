package com.sondahum.spark;

import org.apache.spark.SparkConf;

public class MySparkRunner {
    private MySpark mySpark;
    private SparkConf sparkConf;

    public static void main(String[] args) {
        setSparkConf();
    }

    public void setSparkConf() {
        sparkConf = new SparkConf()
                .setAppName("my_spark_1")
                .setMaster("local[1]")
                .
    }
}
