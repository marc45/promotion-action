package com.promotion.action.concurrent.sys.util;


import java.util.concurrent.CountDownLatch;

/**
 * 模拟3个程序员干活，3个人都完成了项目才能上线
 */
public class CountDownLatchTest2 {
    //主线程
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(3);

        //创建三个线程
        Thread thread = new Thread(new Worker("Jack 程序员1 ：", latch));
        Thread thread1 = new Thread(new Worker("Kate 程序员2 ：", latch));
        Thread thread2 = new Thread(new Worker("Tom 程序员3 ：", latch));

        thread.start();
        thread1.start();
        thread2.start();

        //使得当前线程（主线程）一直等待，知道锁存器倒数为0
        latch.await();
        System.out.println("主线程结束，项目上线完成");
    }

    static class Worker implements Runnable {

        private String workerName;
        private CountDownLatch latch;

        public Worker(String workerName, CountDownLatch latch) {
            this.workerName = workerName;
            this.latch = latch;
        }

        public void run() {
            //模拟干活
            try {
                System.out.println("worker : " + workerName + " is begin.");
                Thread.sleep(1000L);
                System.out.println("worker : " + workerName + " is end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //递减锁存器，并计数
            latch.countDown();
        }
    }
}
