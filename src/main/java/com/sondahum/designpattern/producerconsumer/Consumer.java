package com.sondahum.designpattern.producerconsumer;


public class Consumer extends Thread {
    private final MyBlockingQueue myBlockingQueue;
    private final String name;

    public Consumer(MyBlockingQueue myBlockingQueue, String name) {
        this.setName(name);
        this.myBlockingQueue = myBlockingQueue;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            // 맨 처음 consumer가 실행됐을땐 producer가 sleep상태다.
            String packet = myBlockingQueue.take();
            System.out.println(name + " : " + packet);
        }
    }
}
