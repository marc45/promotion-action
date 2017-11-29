package com.promotion.action.pattern.proxy.quiet;

public class TestApp {

    public static void main(String[] args) {

        RealRailwayTicket ticket = new RealRailwayTicket();

        ProxyRailwayTicket proxyRailwayTicket = new ProxyRailwayTicket(ticket);

        proxyRailwayTicket.buy();

    }
}
