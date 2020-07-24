package com.sondahum.designpattern.producerconsumer;

public class BQ {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public BQ(int count) {
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
