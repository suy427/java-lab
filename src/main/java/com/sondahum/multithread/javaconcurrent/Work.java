package com.sondahum.multithread.javaconcurrent;

import org.apache.spark.sql.Dataset;

import java.util.concurrent.Callable;

public class Work implements Callable<Dataset> {

    @Override
    public Dataset call() throws Exception {
        return null;
    }
}
