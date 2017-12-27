package com.promotion.action.pattern.observer.player;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题类:观察目标
 */
abstract class Subject {

    /*战队名称*/
    protected String teamName;

    /*存储观察者集合*/
    protected List<Observer> players = new ArrayList<Observer>();

    /*通知每个观察者对象方法*/
    abstract void notify(String name);

    /*观察者加入战队（绑定观察者）*/
    public void join(Observer observer) {
        System.out.println(observer.getName() + "加入" + teamName + "战队！");
        players.add(observer);
    }

    /*观察者退出战队（解绑观察者）*/
    public void delete(Observer observer) {
        System.out.println(observer.getName() + "退出" + teamName + "战队！");
        players.remove(observer);
    }
}



