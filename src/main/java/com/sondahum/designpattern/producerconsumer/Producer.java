package com.sondahum.designpattern.producerconsumer;

import lombok.SneakyThrows;

public class Producer extends Thread {
    BQ bq;
    private static int id=0;

    Producer(BQ bq) {
        this.setName("ProducerThread");
        this.bq = bq;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000); // 첫 시작때, 이 1초동안 consumer가 실행된다.
                String packet = "No : " + nextId();
                bq.put(packet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
