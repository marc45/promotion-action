package com.jd.jr.concurrent.sys.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by shifeifei on 2017/4/19.
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);//创建具有给定的许可数

        //启动10个线程,相当于10个人上厕所,但厕所只有三个坑
        for (int i = 1; i <= 10; i++) {

            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        //从此信号量获取给定数目的许可,在提供这些许可前一直将线程阻塞
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程," + Thread.currentThread().getName() + "进入,当前已有:" + (3 - semaphore.availablePermits()) + "并发");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程," + Thread.currentThread().getName() + "即将离开");
                    semaphore.release(); //释放一个许可,将其返回给信号量
                    System.out.println("线程," + Thread.currentThread().getName() + "已离开,当前已有:" + (3 - semaphore.availablePermits()) + "并发");
                }
            };
            service.execute(runnable);
        }
    }
}
