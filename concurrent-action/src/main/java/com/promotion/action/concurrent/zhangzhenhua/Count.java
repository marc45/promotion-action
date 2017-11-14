package com.promotion.action.concurrent.zhangzhenhua;

/**
 * 5个用户都来给一个数字加1
 */
public class Count {

    private Integer num = 0;

    public void add() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "," + num);
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
}


class ThreadA implements Runnable {

    private Count count;

    public ThreadA(Count count) {
        this.count = count;
    }

    public void run() {
        count.add();
    }
}

class MainDemo {

    public static void main(String[] args) {
        Count count = new Count();

        for (int i = 1; i < 6; i++) {
            Thread task = new Thread(new ThreadA(count));
            task.start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("五个人干完活后的值：" + count.getNum());

    }

}