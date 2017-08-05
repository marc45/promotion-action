package com.promotion.action.pattern.created.complex.factory;

/**
 * Created by shifeifei on 2017/3/29.
 */
public class Test {

    public static void main(String[] args) {

        //生产汉兰达SUV
        SuvFactory suv = new HighlanderFactory();

        IEngine engine = suv.createdEngine("Highlander");
        ITire tire = suv.createdTire("Highlander");

        engine.printEngine();
        tire.printTire();

        System.out.println("------------------------");

        //生产牧马人SUV
        suv = new WranglerFactory();

        engine = suv.createdEngine("Wrangler");
        tire = suv.createdTire("Wrangler");

        engine.printEngine();
        tire.printTire();

    }

}
