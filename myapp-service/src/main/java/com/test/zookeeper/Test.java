package com.test.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by zhaogang3 on 2017/2/25.
 */
public class Test {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 30000, new ZkWatcher());

        String node = "/app1/test";
        Stat stat = zk.exists(node, false);
        if (stat == null) {
            zk.create(node, "testData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }
}
