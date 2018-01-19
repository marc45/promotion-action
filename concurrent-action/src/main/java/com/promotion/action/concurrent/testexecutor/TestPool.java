package com.promotion.action.concurrent.testexecutor;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPool {

    //存放等待执行的任务
    private final BlockingQueue<Runnable> workQueue;
    //线程池锁, 对poolSize, corePoolSize,maximumPoolSize, runState, workers的修改都要使用该锁
    private final ReentrantLock mainLock = new ReentrantLock();
    private final Condition termination = mainLock.newCondition();
    //存放所有工作的线程
    private final HashSet<Worker> workers = new HashSet<Worker>();
    //当线程没有任务处理后能存活多长时间
    private volatile long keepAliveTime;
    /**
     * false:即使核心线程闲置,它也是存活的
     * true:核心线程存活时间是keepAliveTime
     */
    private volatile boolean allowCoreThreadTimeOut;
    //核心池的大小(即线程池中的线程数目大于这个参数时,提交的任务会被放进任务缓存队列)
    private volatile int corePoolSize;
    //线程池中最大线程数
    private volatile int maximumPoolSize;
    //线程池中当前线程数
    private volatile int poolSize;
    //任务拒绝策略
    private volatile RejectedExecutionHandler handler;
    //线程工厂,用来创建线程
    private volatile ThreadFactory threadFactory;
    //用来记录线程池中曾经出现过的最大线程数
    private int largestPoolSize;
    //用来记录已经执行完毕的任务个数
    private long completedTaskCount;
    //默认的任务拒绝策略
    private static final RejectedExecutionHandler defaultHandler =
            new ThreadPoolExecutor.AbortPolicy();

    public TestPool(BlockingQueue<Runnable> a) {
        this.workQueue = a;
    }


}
