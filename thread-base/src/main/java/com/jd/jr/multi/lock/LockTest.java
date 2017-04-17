package com.jd.jr.multi.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shifeifei on 2017/3/11.
 */
public class LockTest {


    static LockTest lockTest = new LockTest();

    public static void main(String[] args) {
        lockTest.init();
    }

    private void init() {
        final Printer printer = new Printer();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print("shifeifei");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print1("guojiangjiang");//print()和print1()方法是同步的
                    //new Printer().print1("guojiangjiang");//print()和print1()方法不同步
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    static class Printer {

        Lock lock = new ReentrantLock();

        public void print(String name) {
            lock.lock();
            try {
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }

        public void print1(String name) {
            lock.lock();

            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
            lock.unlock();
        }

        //静态方法不需要任何对象就可以直接调用，但它需要字节码对象
        public static synchronized void print2(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

    }


}
