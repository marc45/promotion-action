package com.promotion.action.concurrent.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shifeifei on 2017/12/3.
 */
public class ThreadEeecuterTest {


    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                public void run() {
                    System.out.println("into " + no);

                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("end " + no);


                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        System.out.println("Thread Main End");
    }


}
