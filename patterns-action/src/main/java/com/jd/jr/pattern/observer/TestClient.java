package com.jd.jr.pattern.observer;

/**
 * Created by shifeifei on 2017/5/2.
 */
public class TestClient {
    public static void main(String[] args) {

        //创建观察者
        CourierObserver c1 = new CourierObserver();
        c1.setUsername("A1");

        CourierObserver c2 = new CourierObserver();
        c2.setUsername("A2");

        OrderSubject orderSubject = new OrderSubject();
        orderSubject.attach(c1);
        orderSubject.attach(c2);

        //通知观察者
        orderSubject.notify("订单支付完成,请开始配送货物");

        orderSubject.delete(c2);

    }
}
