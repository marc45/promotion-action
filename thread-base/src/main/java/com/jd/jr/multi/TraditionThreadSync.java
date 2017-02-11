package com.jd.jr.multi;

/**
 * Created by shifeifei on 2017/2/11.
 * �̰߳�ȫ����
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
                    printer.print1("guojiangjiang");//��ʱprint()��print1()����ͬ��
                    //new Printer().print1("guojiangjiang");//��ʱprint()��print1()������ͬ��
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //����̷߳��ʸ�Printer���print������������̰߳�ȫ����
    static class Printer {
        public void print(String name) {
            synchronized (this) {//�������print()��print3()����ͬ�����޸ĳ�synchronized(Printer.class)
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

        //��̬��������Ҫ��������Ķ���Ϳ��Ե��ã�������һ�����õ�������ֽ��������Ϊ����ֽ������ص��ڴ���
        public static synchronized void print2(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

    }
}

