package com.promotion.action.concurrent.sys.util;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch sprotManLatch = new CountDownLatch(3);
        CountDownLatch refereeLatch = new CountDownLatch(1);


        Thread thread = new Thread(new SportMan(sprotManLatch, "Kate", refereeLatch, "Lucy"));
        Thread thread1 = new Thread(new SportMan(sprotManLatch, "Tome", refereeLatch, "Lucy"));
        Thread thread2 = new Thread(new SportMan(sprotManLatch, "Jack", refereeLatch, "Lucy"));

        thread.start();
        thread1.start();
        thread2.start();


        //设置裁判员发送起跑命令
        System.out.println("裁判员即将发布命令");
        refereeLatch.countDown();
        System.out.println("裁判员已发布发布命令，在终点等待结果");

        sprotManLatch.await();
        System.out.println("裁判员：" + "Lucy" + "收到结果");

    }

    static class SportMan implements Runnable {

        private CountDownLatch sprotManLatch;
        private String sprotManName;
        private CountDownLatch refereeLatch;
        private String refereeName;

        public SportMan(CountDownLatch sprotManLatch, String sprotManName,
                        CountDownLatch refereeLatch, String refereeName) {
            this.sprotManLatch = sprotManLatch;
            this.refereeLatch = refereeLatch;
            this.sprotManName = sprotManName;
            this.refereeName = refereeName;
        }

        public void run() {
            try {
                System.out.println("运动员 " + sprotManName + ",正在准备等待裁判员 " + refereeName + "发起命令");
                //使当前线程在锁存器倒计数至零之前一直等待,除非线程被中断或超出了指定的等待时间
                refereeLatch.await();
                System.out.println("运动员 " + sprotManName + ",已经接到裁判员 " + refereeName + "的起跑命令");

                //模拟赛跑
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("运动员 " + sprotManName + "正在赛跑");

                //递减锁存器的计数,如果计数到达零,则释放所有等待的线程
                sprotManLatch.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
