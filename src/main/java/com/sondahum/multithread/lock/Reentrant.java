package com.sondahum.multithread.lock;

public class Reentrant {
    // synchronized는 객체(this) 전체에 대한 lock을 control하므로, 재진입이 가능..!
    public synchronized void first() {
        second();
    }

    public synchronized void second() {
        System.out.println("do something (Reentrant)");
    }
}

class NoReentrant {
    // 이렇게 lock을 쓰면 재진입이 불가능..! (코드 읽어보면 알 수 있음)
    MyLock lock = new MyLock();
    MyReentrantLock reLock = new MyReentrantLock();

    public void first() {
        lock.lock();
        second();
        lock.unlock();
    }

    public void second() {
        lock.lock(); // first() 에서 lock을 걸고 second로 진입했기 때문에 자신이 걸어놓은 lock에 block되어서 second 접근 불가.
        System.out.println("do something (No Reentrant)");
        lock.unlock();
    }

    public void outer() {
        reLock.lock();
        inner();
        reLock.unlock();
    }

    public void inner() {
        reLock.lock();
        try {
            System.out.println("inner");
        } finally {
            // try 안에있는 critical section에서도 언제든지 Exception이 발생할 수 있다.
            // 이런 경우 unlock에 도달하지 못하여 영원이 lock에 걸린채로 있을 수도 있기 때문에
            // 항상 finally 블록 등을 이용하여 Exception상황에도 안전하게 unlock할 수 있도록
            // 보장해줘야 한다.
            reLock.unlock();
        }
    }
}