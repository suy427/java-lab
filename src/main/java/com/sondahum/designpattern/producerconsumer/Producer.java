package com.sondahum.designpattern.producerconsumer;

public class Producer extends Thread {
    MyBlockingQueue blockingQueue;
    private static int id=0;

    Producer(MyBlockingQueue blockingQueue) {
        this.setName("ProducerThread");
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000); // 첫 시작때, 이 1초동안 consumer가 실행된다.
                String packet = "No : " + nextId();
                blockingQueue.put(packet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
