package com.jd.jr.pattern.created.complex.factory;

/**
 * Created by shifeifei on 2017/3/29.
 * 汉兰达suv工厂
 */
public class HighlanderFactory implements SuvFactory {
    public IEngine createdEngine(String engine) {
        return new Engine(engine);
    }

    public ITire createdTire(String tire) {
        return new Tire(tire);
    }
}
