package com.promotion.action.pattern.proxy.quiet;

/**
 * 代理对象
 */
public class ProxyRailwayTicket implements RailwayTicket {

    private RailwayTicket railwayTicket;

    public ProxyRailwayTicket(RailwayTicket railwayTicket) {
        this.railwayTicket = railwayTicket;
    }

    public void buy() {
        System.out.println("----------------");
        railwayTicket.buy();
        System.out.println("----------------");
    }

}
