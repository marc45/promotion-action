package com.promotion.action.concurrent.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shifeifei on 2017/3/5.
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        Future<String> future = threadPool.submit(new Callable<String>() {

            public String call() throws Exception {
                Thread.sleep(100);
                return "hello";
            }
        });

        try {
            System.out.println("拿到结果:" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }
}
