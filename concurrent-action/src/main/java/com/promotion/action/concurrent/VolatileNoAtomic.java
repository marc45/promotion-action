package com.promotion.action.concurrent;

/**
 * Created by shifeifei on 2017/4/30.
 */
public class VolatileNoAtomic extends Thread {

    private static volatile int count = 0;

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(count);
    }

    public void run() {
        addCount();
    }

    public static void main(String[] args) {

        VolatileNoAtomic[] atomics = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            atomics[i] = new VolatileNoAtomic();
        }

        for (int i=0;i<10;i++) {
            atomics[i].start();
        }
    }
}
