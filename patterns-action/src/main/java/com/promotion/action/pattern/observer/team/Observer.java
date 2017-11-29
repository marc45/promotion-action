package com.promotion.action.pattern.observer.team;


/**
 * 抽象观察者类
 * 学习博客：http://blog.csdn.net/lovelion/article/details/17517213
 */
public interface Observer {

    String getName();

    void setName(String name);

    //支援盟友方法
    void help();

    //遭受攻击方法
    void beAttacked(AllyControlCenter acc);

}
