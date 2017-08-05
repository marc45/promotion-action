package com.jd.jr.zk.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by shifeifei on 2017/5/20.
 */
public interface HelloService extends Remote{

    String sayHello(String name) throws RemoteException;

}
