package com.jd.jr.concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shifeifei on 2017/3/11.
 * 读写锁
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        //共享数据封装类
        final Queue queue = new Queue();

        for (int i = 0; i < 3; i++) {
            //创建3个线程不断从队列中获取数据
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        queue.get();
                    }
                }
            }).start();

            //创建3个线程不断往队列中填充数据
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        queue.set(new Random().nextInt(10000));
                    }
                }
            }).start();
        }
    }
}

class Queue {
    //共享数据,只能有一个线程能写改数据,但可以有多个线程同时读该数据
    private Object data = null;
    //读写锁
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        //上读锁
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",reading data start");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",reading data completed, data=" + data);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(Object data) {
        //上写锁
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",writing data start");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + ",writing data completed, data=" + data);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
