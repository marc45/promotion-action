package com.jd.jr.concurrent;

/**
 * Created by shifeifei on 2017/4/29.
 * 多个线程多个锁对象
 */
public class MultiThread {

    private static int num = 0;

    public static synchronized void printNum(String tag) {
        try {
            if ("a".equals(tag)) {
                num = 100;
                System.out.println("tag a,set num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b,set num over");
            }

            System.out.println("tag " + tag + ",num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        new Thread(new Runnable() {
            public void run() {
                m1.printNum("a");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                m2.printNum("b");
            }
        }).start();

    }

}
