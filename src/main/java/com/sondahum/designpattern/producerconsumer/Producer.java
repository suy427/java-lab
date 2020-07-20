package com.sondahum.designpattern.producerconsumer;

import lombok.SneakyThrows;

public class Producer extends Thread {
    BQ bq;
    private static int id;

    Producer(BQ bq) {
        this.bq = bq;
    }

    @SneakyThrows
    @Override
    public void run() {
        while(true) {
            Thread.sleep(1000);
            String packet = "No : " + nextId();
            bq.put(packet);
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
