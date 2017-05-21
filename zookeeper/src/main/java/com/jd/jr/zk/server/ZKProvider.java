package com.jd.jr.zk.server;

import com.jd.jr.zk.common.Constant;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shifeifei on 2017/5/20.
 */
public class ZKProvider {

    private static final Logger logger = LoggerFactory.getLogger(ZKProvider.class);

    /**
     * 用于等待SyncConnected事件触发后执行当前线程
     */
    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 发布RMI服务并注册RMI地址到zookeeper中
     *
     * @param remote
     * @param host
     * @param port
     */
    public void publish(Remote remote, String host, int port) {
        /* 发布RMI服务，并返回RMI地址 */
        String url = publishService(remote, host, port);
        if (StringUtils.isNotBlank(url)) {
            /*连接zookeeper服务器，并获取zookeeper对象*/
            ZooKeeper zk = connectServer();
            if (null != zk) {
                /*创建ZNode节点，并将RMI地址放入ZNode上*/
                createdNode(zk, url);
            }
        }

    }

    /**
     * 创建ZNode
     *
     * @param zk
     * @param url
     */
    private void createdNode(ZooKeeper zk, String url) {
        byte[] data = url.getBytes();
        try {
            //创建一个临时有序znode节点
            String path = zk.create(Constant.ZK_PROVIDER_PATH, data,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.info("create zookeeper node ({} ==> {})", path, url);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * 连接zookeeper服务器
     *
     * @return
     */
    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        //唤醒当前正在执行的线程
                        latch.countDown();
                    }
                }
            });
            //使当前线程处于等待状态
            latch.await();
        } catch (Exception e) {
            logger.error("", e);
        }
        return zk;
    }

    private String publishService(Remote remote, String host, int port) {
        String url = null;
        url = String.format("rmi://%s:%d/%s", host, port, remote.getClass().getName());
        logger.debug(url+",----");
        try {
            LocateRegistry.createRegistry(port);
            Naming.bind(url, remote);

            logger.info("publish rmi service (url: {}),", url);
        } catch (Exception e) {
            logger.error("发布服务异常", e);
        }
        return url;
    }


}
