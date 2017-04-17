package com.jd.jr.multi.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shifeifei on 2017/3/11.
 * 读写锁
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final Queue queue = new Queue();
        for (int i = 0; i < 3; i++) {

            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        queue.get();
                    }
                }
            }).start();


            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        queue.set(new Random(1000));
                    }
                }
            }).start();


        }
    }
}

/**
 * 封装共享数据
 */
class Queue {

    //共享数据,只能有一个线程能写改数据,但可以有多个线程同时读该数据
    private Object data = null;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get() {
        System.out.println(Thread.currentThread().getName() + ",准备开始读数据");

        try {
            Thread.sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ",数据读已经完成");

    }


    public void set(Object data) {

        System.out.println(Thread.currentThread().getName() + ",准备开始写数据");
        try {
            Thread.sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + ",写数据完成");


    }


}
