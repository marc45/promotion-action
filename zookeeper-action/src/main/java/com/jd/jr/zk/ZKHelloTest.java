package com.jd.jr.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * Created by shifeifei on 2017/5/21.
 */
public class ZKHelloTest {


    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("172.24.7.165:2182", 300000, new DemoWatcher());//连接zk server
        String node = "/test";
        Stat stat = zk.exists(node, false);//检测/app1是否存在
        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }


    static class DemoWatcher implements Watcher {
        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }
}
