package com.sondahum.designpattern.producerconsumer;


public class Runner {
    public static void main(String[] args) {

        BQ bq = new BQ(100);
        new Producer(bq).start();
        new Consumer(bq, "consumer1").start();
        new Consumer(bq, "consumer2").start();
        new Consumer(bq, "consumer3").start();
    }
}