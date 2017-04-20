package com.jd.jr.autowire;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shifeifei on 2017/4/19.
 */
public class Communication {
    public static void main(String[] args) {
        final Print print = new Print();

        //子线程
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    print.sub(i);
                }
            }
        }).start();

        //主线程
        for (int i = 1; i <= 50; i++) {
            print.main(i);
        }
    }
}

class Print {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean startSub = true;//标识子线程先执行

    public void sub(int i) {
        lock.lock();
        try {
            //假如不是子线程执行，那让给主线程执行，此时子线程等待
            while (!startSub) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //该我子线程执行
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread print j=" + j + ",执行第 i=" + i);
            }
            startSub = false;
            condition.signal();//唤醒主线程
        } finally {
            lock.unlock();
        }
    }

    public synchronized void main(int i) {
        lock.lock();
        try {
            //假如不是我主线程执行，那让子线程执行，此时主线程等待
            while (startSub) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("main thread print j=" + j + ",执行第 i=" + i);
            }
            startSub = true;
            condition.signal();//唤醒子线程
        } finally {
            lock.unlock();
        }
    }
}
