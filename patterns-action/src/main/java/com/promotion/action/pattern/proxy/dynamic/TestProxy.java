package com.promotion.action.pattern.proxy.dynamic;

import com.promotion.action.pattern.proxy.quiet.RailwayTicket;
import com.promotion.action.pattern.proxy.quiet.RealRailwayTicket;

public class TestProxy {

    public static void main(String[] args) {

        RailwayTicket ticket = (RailwayTicket) new RailwayTicketProxy().getProxy(new RealRailwayTicket());
        ticket.buy();


        //创建真实对象
        RailwayTicket ticket1 = new RealRailwayTicket();
        //原始对象类型
        System.out.println(ticket1.getClass()+",目标对象的接口类型："+ticket1.getClass().getInterfaces()[0]);
        //给目标对象创建代理对象
        RailwayTicket proxy = (RailwayTicket) new ProxyFactory(ticket1).getProxy();
        //内存中生成代理对象类型
        System.out.println(proxy.getClass());
        proxy.buy();
    }

}
