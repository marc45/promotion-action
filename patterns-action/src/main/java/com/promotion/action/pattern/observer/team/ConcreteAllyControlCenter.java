package com.promotion.action.pattern.observer.team;


/**
 * 具体被观察者
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter() {
    }

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "组建战队");
        System.out.println("------------------------------");
        this.allyName = allyName;
    }

    /**
     * 通知方法
     *
     * @param message 通知消息
     */
    void notify(String message) {
        System.out.println(this.allyName + "战队紧急通知，盟友" + message + "遭受敌人攻击");

        //遍历观察者集合，调用每一个盟友的支援方法
        for (Observer player : players) {
            if (!player.getName().equalsIgnoreCase(message)) {
                player.help();
            }
        }
    }
}
