package com.sondahum.designpattern.producerconsumer;

public class MyBlockingQueue {
    // java.util.concurrent 패키지에 BlockingQueue가 구현이 되어있다.
    // 동작방식은 같은 맥락이지만 당연히 이거보다 훨씬 좋다.
    // String 배열 buffer를 BlockingQueue<String> buffer로 쓰고, put, take는 제공된 queue의 put과 take를 그대로 쓰면된다.
    // 하지만 blockingQueue사용도 결국 '동기화 객체를 사용한다' 는데.. 동기화 객체가 뭐지..?
    // actor 패턴으로...
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public MyBlockingQueue(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String packet) {
        while(count >= buffer.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        }

        buffer[tail] = packet;
        tail = (tail+1) % buffer.length;
        count++;

        notifyAll();
    }

    public synchronized String take() {
        while (count <= 0) { // producer가 sleep상태일때는 sleep으로 들어간다.
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        }

        String packet = buffer[head];
        head = (head+1) % buffer.length;
        count--;
        notifyAll(); // 누가 다음으로 BQ.take()를 호출할지 보장할 수 없다.

        return packet;
    }
}
