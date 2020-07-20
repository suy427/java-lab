package com.sondahum.designpattern.producerconsumer;

import lombok.SneakyThrows;

public class Consumer extends Thread {
    BQ bq;

    public Consumer(BQ bq) {
        this.bq = bq;
    }

    @SneakyThrows // todo 이거 뭔지 알아볼것
    @Override
    public void run() {
        while(true) {
            String packet = bq.take();
            System.out.println("consumer : " + packet);
        }
    }
}
