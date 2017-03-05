package com.jd.jr.multi;

/**
 * Created by shifeifei on 2017/2/11.
 * 线程安全问题
 */
public class TraditionThreadSync {
    private static TraditionThreadSync sync = new TraditionThreadSync();

    public static void main(String[] args) {
        sync.init();
    }

    private void init() {
        final Printer printer = new Printer();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print("shifeifei");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    printer.print1("guojiangjiang");//print()和print1()方法是同步的
                    //new Printer().print1("guojiangjiang");//print()和print1()方法不同步
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    static class Printer {

        public void print(String name) {
            synchronized (this) {//要使print()和print2()方法同步,synchronized(Printer.class)才起作用
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void print1(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        //静态方法不需要任何对象就可以直接调用，但它需要字节码对象
        public static synchronized void print2(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

    }
}

