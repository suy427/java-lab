package com.sondahum.multithread.lock;


import java.util.ArrayList;
import java.util.List;

public class MyLock {
    private boolean isLocked = false;

    public synchronized void lock() {
        try {
            while (isLocked) {
                // wait()는 호출됨과 동시에 이 메서드를 호출한 thread의 lock을 해제한다.
                // 이 lock() 메서드에는 synchronized가 붙어있기 때문에, 둘 이상의 thread가
                // 이 메서드로 아예 진입조차 못하는게 맞는데, wait() 때문에 그것이 가능하다.
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

class MyReentrantLock {
    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockedCount = 0;

    public synchronized void lock() {
        Thread callingThread = Thread.currentThread();

        try { // 이 try-catch는 그냥 밖에서 throws 붙이기 싫어서 넣은거임...ㅎ
            // 자신이 걸었던 lock에는 다시 빠지지 않는다. 즉, reentrance 가능
            while (isLocked && lockedBy != callingThread) { // this loop is spin loop.
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }

    // synchronized는 thread들의 진입 순서를 신경쓰지 않는다.
    // 따라서 예를들어 lock에 걸린 A thread가 unlock되는 시점에
    // 새로운 B thread가 lock에 진입하면 걔가 먼저 unlock되고, 이와 같은 현상이 반복되면
    // A thread는 영영 lock에 걸려있을 수도 있다. 이를 '기아상태'라고 한다.
    // 현재 구현한 MyLock class는 내부적으로 synchronized를 사용하기 때문에
    // 기아상태를 피할 방법이 없다. ==> lock 공정성을 가지지 않는다.
    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;

            if (lockedCount == 0) {
                isLocked = false;
                notify(); // 얘는 누굴 깨우나..?
            }
        }
    }
}

class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<ThreadObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        ThreadObject currentEnteredThread = new ThreadObject();
        boolean isLockedForThisThread = true;

        synchronized (this) {
            waitingThreads.add(currentEnteredThread);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread =
                        isLocked || waitingThreads.get(0) != currentEnteredThread;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreads.remove(currentEnteredThread);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            // note isLockedForThisThread 즉, 이 thread를 잠궈야하냐?에서 true가 나왔으므로 spin loop를 돌게 만든다.
            try { // 여기가 spin loop다.
                currentEnteredThread.doWait(); // doWait가 안된다는 말은 --> 권한 없는 애가 얘를 건드렸다..?
            } catch (InterruptedException e) {
                synchronized (this) { waitingThreads.remove(currentEnteredThread); }
                throw e;
            }
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("The calling thread doesn't have this lock.");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}
