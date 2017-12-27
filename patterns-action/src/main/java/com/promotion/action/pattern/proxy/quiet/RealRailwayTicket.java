package com.promotion.action.pattern.proxy.quiet;

/**
 * 真实目标
 */
public class RealRailwayTicket implements RailwayTicket {

    public void buy() {
        System.out.println("购买火车票");
    }
}


