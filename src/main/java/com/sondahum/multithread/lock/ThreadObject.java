package com.sondahum.multithread.lock;

public class ThreadObject {
    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while(!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    public boolean equals(Object o) {
        return this == o;
    }
}
// note 블락 조건..!
// isLockedForThisThread는 결국 이 thread가 access 가능하냐?를 묻는거다.
// 따라서 이유불문하고 isLocked가 true면 걍 잠긴거다.
// 근데, 현재 lock이 안걸려있더라도 현재 thread 보다 먼저 대기중인 thread가 있으면
// 먼저 대기중인 thread가 먼저 처리될 수 있도록 기다려 준다. (fair)