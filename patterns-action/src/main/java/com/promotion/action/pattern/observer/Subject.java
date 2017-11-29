package com.promotion.action.pattern.observer;

/**
 * Created by shifeifei on 2017/5/2.
 * 主题：被观察者的抽象对象(发布者)
 */
public abstract class Subject {

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    abstract void attach(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    abstract void delete(Observer observer);

    /**
     * 通知观察者
     *
     * @param message 通知消息
     */
    abstract void notify(String message);

}
