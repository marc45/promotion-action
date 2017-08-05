package com.jd.jr.pattern.observer;

/**
 * Created by shifeifei on 2017/5/2.
 * 被观察者的抽象对象
 */
public interface Subject {

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void attach(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void delete(Observer observer);

    /**
     * 通知观察者
     *
     * @param message 通知消息
     */
    void notify(String message);

}
