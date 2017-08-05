package com.promotion.action.zk.common;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class Constant {

    public final static String ZK_CONNECTION_STRING = "172.24.7.165:2182,172.24.7.165:2181,172.24.7.165:2183";

    public final static int ZK_SESSION_TIMEOUT = 5000;

    public final static String ZK_REGISTRY_PATH = "/registry";

    public final static String ZK_PROVIDER_PATH = ZK_REGISTRY_PATH +"/provider";

}
