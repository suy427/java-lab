package com.sondahum.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class MySpark {
    private SparkSession sparkSession;

    void MySpark(SparkConf conf) {
        sparkSession = SparkSession
                .builder()
                .config(conf)
                .getOrCreate();
    }


}
