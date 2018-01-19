package com.promotion.action.concurrent.testexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingThreadExecutorTest {


    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println("into" + no);
                        Thread.sleep(1000L);
                        System.out.println("end" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        System.out.println("Thread main end");
    }

}
