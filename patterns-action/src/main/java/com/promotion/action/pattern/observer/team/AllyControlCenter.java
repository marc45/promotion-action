package com.promotion.action.pattern.observer.team;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标类，被观察者抽象
 */
abstract class AllyControlCenter {

    protected String allyName;

    //用于存储观察者，这里是战队成员
    protected List<Observer> players = new ArrayList<Observer>();


    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void attach(Observer observer) {
        System.out.println(observer.getName() + "加入" + this.allyName + "战队");
        players.add(observer);
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    void delete(Observer observer) {
        System.out.println(observer.getName() + "退出" + this.allyName + "战队");
        players.remove(observer);
    }

    /**
     * 通知观察者
     *
     * @param message 通知消息
     */
    abstract void notify(String message);

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
}
