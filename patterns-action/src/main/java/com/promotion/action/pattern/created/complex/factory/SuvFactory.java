package com.promotion.action.pattern.created.complex.factory;

/**
 * Created by shifeifei on 2017/3/29.
 * SUV抽象工厂
 */
public interface SuvFactory {

    IEngine createdEngine(String engine);

    ITire createdTire(String tire);
}
