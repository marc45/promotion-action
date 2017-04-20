package com.jd.jr.multi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by shifeifei on 2017/2/12.
 * 线程范围内的共享变量：创建三个线程，它们都访问了三个对象，第一个对象设置值，第二三对象取值，同一个线程
 * 设置的值，只能被相同的线程获取;变量在线程内共享，在线程外独立
 */
public class ThreadLocalMapTest {

    private static Integer data = 0;

    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(
                    new Runnable() {
                        public void run() {
                            data = new Random().nextInt();
                            System.out.println("线程准备数据," + Thread.currentThread().getName() + "---->  data=" + data);
                            threadData.put(Thread.currentThread(), data);

                            new A().get();//A线程取数据
                            new B().get();//B线程取数据
                            //我们要达到的效果是，A 和 B 在同一个线程内取到的数是相同的
                        }
                    }
            ).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class A {
        private void get() {
            data = threadData.get(Thread.currentThread());
            System.out.println("A," + Thread.currentThread().getName() + "---->  data=" + data);
        }
    }

    static class B {
        private void get() {
            data = threadData.get(Thread.currentThread());
            System.out.println("B," + Thread.currentThread().getName() + "---->  data=" + data);
        }
    }

}
