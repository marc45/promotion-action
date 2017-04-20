package com.jd.jr.autowire.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shifeifei on 2017/4/19.
 * 读写锁模拟一个缓存方法
 */
public class Cache {

    //用Map模拟缓存,将数据库中查询到的数据存放到里面
    private Map<String, String> cache = new HashMap<String, String>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //当多个线程操作此方法读数据时,可能会出现线程安全问题
    private Object get(String key) {
        Object data = null;

        lock.readLock().lock();
        try {
            data = cache.get(key);
            if (null == data) {
                //这里给data赋值,相当于写数据,所以此时要打断读锁上写锁
                lock.readLock().unlock();
                lock.writeLock().lock();

                try {
                    //假如有三个线程同时要上写锁,第一个上锁成功,后面的线程执行到这里就不再赋值
                    if (null == data) {
                        data = "aaa";//这里的操作实际上是去数据库查询数据
                    }
                } finally {
                    lock.writeLock().unlock();
                }

                //写锁执行完成后在上读锁
                lock.readLock().lock();
            }
        } finally {
            lock.readLock().unlock();
        }
        return data;
    }
}
