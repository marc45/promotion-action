package com.promotion.action.pattern.created.complex.factory;

/**
 * Created by shifeifei on 2017/3/29.
 * 发动机产品
 */
public class Engine implements IEngine {

    private String engine;

    public Engine(String engine) {
        this.engine = engine;
    }

    public void printEngine() {
        System.out.println(this.engine + ",发动机制造成功");
    }
}
