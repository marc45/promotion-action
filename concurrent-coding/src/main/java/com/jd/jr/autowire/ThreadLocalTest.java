package com.jd.jr.autowire;

import java.util.Random;

/**
 * Created by shifeifei on 2017/2/12.
 * 线程范围内的共享变量：创建三个线程，它们都访问了三个对象，第一个对象设置值，第二三对象取值，同一个线程
 * 设置的值，只能被相同的线程获取;变量在线程内共享，在线程外独立
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadScopeData> myLocalData = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        public void run() {
                            int data = new Random().nextInt();
                            System.out.println("线程准备数据," + Thread.currentThread().getName() + "---->  data=" + data);
                            local.set(data);


                            //线程内共享一个对象变量设置
                            MyThreadScopeData scopeData = new MyThreadScopeData();
                            scopeData.setAge(data);
                            scopeData.setName("name: " + data);
                            myLocalData.set(scopeData);

                            //更好的实现方式
                            MyThreadScopeData.getInstance().setName("Tom-"+data);
                            MyThreadScopeData.getInstance().setAge(data);


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
            System.out.println("A," + Thread.currentThread().getName() +
                    "---->  data=" + local.get() + "----->" + myLocalData.get() +",高级实现--->"+MyThreadScopeData.getInstance());
        }
    }

    static class B {
        private void get() {
            System.out.println("B," + Thread.currentThread().getName() +
                    "---->  data=" + local.get() + "----->" + myLocalData.get()+",高级实现--->"+MyThreadScopeData.getInstance());
        }
    }
}

class MyThreadScopeData {

    private int age;
    private String name;
    private static ThreadLocal<MyThreadScopeData> localMap = new InheritableThreadLocal<MyThreadScopeData>();

    public static MyThreadScopeData getInstance() {
        MyThreadScopeData data = localMap.get();
        if (null == data) {
            data = new MyThreadScopeData();
            localMap.set(data);
        }
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyThreadScopeData{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
