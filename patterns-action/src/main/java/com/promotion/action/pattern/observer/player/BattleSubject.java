package com.promotion.action.pattern.observer.player;

/**
 * 具体目标类，具体的观察目标
 */
public class BattleSubject extends Subject {

    public BattleSubject(String teamName) {
        System.out.println(teamName + "战队组建成功");
        System.out.println("------------------------------------------------");
        this.teamName = teamName;
    }

    void notify(String name) {
        System.out.println(this.teamName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
        System.out.println("------------------------------------------------");
        //遍历观察者集合，调用每一个盟友（自己除外）的支援方法
        for (Object obs : players) {
            if (!((Observer) obs).getName().equalsIgnoreCase(name)) {
                ((Observer) obs).help();
            }
        }
    }
}

