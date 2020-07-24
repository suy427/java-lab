package com.sondahum.designpattern.producerconsumer;


public class Runner {
    public static void main(String[] args) {

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);
        new Producer(myBlockingQueue).start();

        // 여기서 consumer는 위에서 한번 만든 blockingqueue를 공유한다.
        // 이걸보고 동기화 객체라고 하는거 같다.
        // actor패턴에서는 각자가 queue를 가진다는데 그건 designpattern.actor 에서 다루기로..
        new Consumer(myBlockingQueue, "consumer1").start();
        new Consumer(myBlockingQueue, "consumer2").start();
        new Consumer(myBlockingQueue, "consumer3").start();
    }
}