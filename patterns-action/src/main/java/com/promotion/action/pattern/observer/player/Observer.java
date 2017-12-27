package com.promotion.action.pattern.observer.player;

/**
 * 观察者
 */
public interface Observer {
    /*声明支援*/
    void help();

    /*遭受攻击方法*/
    void beAttacked(Subject subject);

    /*获取队友名称*/
    String getName();
}



