package com.test.zkbook;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by zhaogang3 on 2017/3/11.
 */
public class Master implements Watcher {
    public static final Logger logger = LoggerFactory.getLogger(Master.class);

    ZooKeeper zk;
    String hostPort;

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws InterruptedException {
        zk.close();
    }

    @Override
    public void process(WatchedEvent event) {
        logger.info(JSON.toJSONString(event));
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        Master m = new Master("127.0.0.1:2181");
        m.startZK();
        Thread.sleep(3000);
        m.stopZK();
    }
}
