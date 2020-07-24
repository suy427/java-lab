package com.sondahum.multithread.lock;

public class ThreadObject {
    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        // note 이 while은 결국 wait에서 깨어나도 isNotified에 의해 다시 wait로 빠질 수 있단거다.
        // note 이 whild은 sprious wake를 방지하는건데, sprious wake는 notify 등의 아무 원인 없이
        // note 갑자기 혼자 깨어나게 되는 현상인데.. 원인은 모르겠지만 발생 할 수 있는 현상이란다...
        while(!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        // note notify는 호출되는 객체의 wait 호출로 인해 대기중인 thread중 'RANDOM'으로 하나를 깨운다..
        // note ---> 정말 'RANDOM'인가..?
        this.notify();
    }

    public boolean equals(Object o) {
        return this == o;
    }
}
