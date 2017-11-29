package com.promotion.action.pattern.observer.team;


/**
 * 具体观察者，游戏玩家
 */
public class Player implements Observer {

    private String name;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 支援盟友方法
     */
    public void help() {
        System.out.println("坚持住，" + this.name + "来救你");
    }

    /**
     * 遭受攻击方法：当遭受攻击时调用被观察者的通知方法来通知盟友
     *
     * @param acc
     */
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "被攻击");
        acc.notify(name);
    }
}
