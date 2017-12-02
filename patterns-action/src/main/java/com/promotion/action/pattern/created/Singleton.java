package com.promotion.action.pattern.created;

/**
 * 饿汉式
 */
public class Singleton {
    private volatile static Singleton singleton = null;
    private Singleton() {
    }
    //对外提供公用的静态方法
    public static Singleton getSingleton() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
