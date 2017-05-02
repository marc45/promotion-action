package com.jd.jr.pattern.created.complex.factory;

/**
 * Created by shifeifei on 2017/3/29.
 * 轮胎产品
 */
public class Tire implements ITire {

    private String tire;

    public Tire(String tire) {
        this.tire = tire;
    }

    public void printTire() {
        System.out.println(this.tire + ",轮胎制造成功");
    }
}
