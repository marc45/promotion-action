package com.promotion.action.concurrent.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shifeifei on 2017/3/5.
 * 线程池使用
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        //固定的线程池：线程池子里有3个线程,就是能并行处理3个任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //启动10个线程,每个线程执行的任务是：打印当前线程名字10次
        for (int i = 1; i < 11; i++) {

            final int task = i;
            executorService.execute(new Runnable() {

                public void run() {

                    for (int j = 1; j < 11; j++) {

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("池子中当前线程是i=" + task + ",执行第j=" + j + "次打印操作," + Thread.currentThread().getName());

                    }
                }
            });


        }

        //执行完成,结束全部线程
        executorService.shutdown();
    }

}
