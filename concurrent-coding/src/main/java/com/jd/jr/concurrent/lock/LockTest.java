package com.jd.jr.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shifeifei on 2017/3/11.
 */
public class LockTest {

    //打印字符串业务逻辑
    static class Printer {
        Lock lock = new ReentrantLock();

        public void print(String name) {
            //上锁
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                //不论发生什么情况,都释放锁
                lock.unlock();
            }
            System.out.println();
        }
    }

    private void init() {
        final Printer printer = new Printer();
        //启动线程一
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print("111111");
                }
            }
        }).start();

        //启动线程二
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print("222222");
                }
            }
        }).start();
    }

    static LockTest lockTest = new LockTest();

    public static void main(String[] args) {
        lockTest.init();
    }
}
