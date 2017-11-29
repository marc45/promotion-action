package com.promotion.action.pattern.observer;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shifeifei on 2017/5/2.
 * 订单被观察者,具体目标
 */
public class OrderSubject extends Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知观察者
     *
     * @param message 通知消息
     */
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * 删除观察者
     *
     * @param observer
     */
    public void delete(Observer observer) {
        observers.remove(observer);

        Iterator<Observer> it = observers.iterator();
        while (it.hasNext()) {
            Observer o = it.next();
            if (o.equals(observer)) {
                it.remove();
            }
        }
        System.out.println("当前还有观察者:" + JSON.toJSONString(observer));
    }
}
