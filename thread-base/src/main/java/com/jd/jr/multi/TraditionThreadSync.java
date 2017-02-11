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
                    printer.print1("guojiangjiang");//此时print()和print1()方法同步
                    //new Printer().print1("guojiangjiang");//此时print()和print1()方法不同步
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //多个线程访问该Printer类的print方法，会出现线程安全问题
    static class Printer {
        public void print(String name) {
            synchronized (this) {//如果想让print()和print3()方法同步，修改成synchronized(Printer.class)
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

        //静态方法不需要创建该类的对象就可以调用，但是它一定会用到该类的字节码对象，因为类的字节码会加载到内存中
        public static synchronized void print2(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

    }
}

