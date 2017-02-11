package com.jd.jr.multi;

/**
 * Created by shifeifei on 2017/2/11.
 */
public class BaseThread {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " <-----> " + this.getName());
                }
            }
        };
        thread.start();

        //实现Runnable接口
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---->" + Thread.currentThread().getName());
                }
            }
        });
        thread1.start();

        //匿名内部类
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---->" + Thread.currentThread().getName());
                }

            }
        }.start();
    }
}
