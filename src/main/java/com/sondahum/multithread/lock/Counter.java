package com.sondahum.multithread.lock;

import java.util.concurrent.locks.Lock;

public class Counter {
    private int count = 0;
    private MyLock lock = new MyLock();

    public int increase() {
        synchronized (this) {
            return ++count;
        }
    }
}
