package com.promotion.action.concurrent;

/**
 * Created by shifeifei on 2017/2/11.
 * 子线程执行10次，主线程100次，如此交替执行，如此循环50次
 *
 * 如何实现：
 *      1.保证主线程和子线程互斥
 *      2.子线程和主线通信
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        ThreadCommunication t = new ThreadCommunication();
        final Business b = t.new Business();

        new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 1; i < 51; i++) {
                            b.subThread(i);
                        }
                    }
                }

        ).start();

        //主线程
        for (int i = 1; i < 51; i++) {
            b.mainThread(i);
        }
    }

    class Business {
        boolean courier = true;//检查那个线程执行

        public synchronized void subThread(int i) {
            while (!courier) {//假如不是我执行，就让主线程执行
                try {
                    this.wait();//不是我执行，我就等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j < 11; j++) {
                System.out.println("子线程,循环次数,j=" + j + ",执行次数,i=" + i);
            }
            courier = false;
            this.notify();
        }

        public synchronized void mainThread(int i) {
            //while能够防止线程假唤醒
            while (courier) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j < 101; j++) {
                System.out.println("主线程,循环次数,j=" + j + ",执行次数,i=" + i);
            }
            courier = true;
            this.notify();
        }

    }

}
