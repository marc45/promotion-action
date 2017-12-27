package com.promotion.action.pattern.proxy.dynamic;

import com.promotion.action.pattern.proxy.quiet.RailwayTicket;
import com.promotion.action.pattern.proxy.quiet.RealRailwayTicket;

public class TestProxy {

    public static void main(String[] args) {

        //创建真实对象
        RailwayTicket ticket1 = new RealRailwayTicket();
        //给目标对象ticket1创建代理对象
        RailwayTicket proxy = (RailwayTicket) new ProxyFactory(ticket1).getProxy();
        proxy.buy();
    }

}

