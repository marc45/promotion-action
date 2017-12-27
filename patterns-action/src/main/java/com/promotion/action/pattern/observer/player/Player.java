package com.promotion.action.pattern.observer.player;

/**
 * 具体观察者：战队成员
 */
public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void help() {
        System.out.println("坚持住，" + this.name + "来救你了");
    }

    //当遭受某个队友遭受攻击时，通过观察目标的通知方法notify()来通知盟友
    public void beAttacked(Subject subject) {
        System.out.println(this.name + "被攻击");
        System.out.println("------------------------------------------------");
        //调用观察目标的通知方法
        subject.notify(name);
    }

    public String getName() {
        return name;
    }
}


