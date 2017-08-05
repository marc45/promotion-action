package com.jd.jr.concurrent.sys.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);//用作一个简单的开/关锁存器

        //用 N 初始化的 CountDownLatch 可以使一个线程在 N 个线程完成某项操作之前一直等待,或者使其在某项操作完成 N 次之前一直等待
        final CountDownLatch cdAnswer = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {

                public void run() {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");

                        //使当前线程在锁存器倒计数至零之前一直等待,除非线程被中断或超出了指定的等待时间
                        cdOrder.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");

                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");

                        //递减锁存器的计数,如果计数到达零,则释放所有等待的线程
                        cdAnswer.countDown();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        //主线程,发送命令
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            cdOrder.countDown();
            System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");

            cdAnswer.await();
            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");

        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
