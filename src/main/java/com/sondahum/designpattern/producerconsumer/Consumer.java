package com.sondahum.designpattern.producerconsumer;


public class Consumer extends Thread {
    private final BQ bq;
    private final String name;

    public Consumer(BQ bq, String name) {
        this.setName(name);
        this.bq = bq;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            // 맨 처음 consumer가 실행됐을땐 producer가 sleep상태다.
            String packet = bq.take();
            System.out.println(name + " : " + packet);
        }
    }
}
