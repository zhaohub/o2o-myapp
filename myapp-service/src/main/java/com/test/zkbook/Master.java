package com.test.zkbook;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * Created by zhaogang3 on 2017/3/11.
 */
public class Master implements Watcher {
    public static final Logger logger = LoggerFactory.getLogger(Master.class);

    ZooKeeper zk;
    String hostPort;

    Random random = new Random();
    String serverId = Integer.toHexString(random.nextInt());

    boolean isLeader = false;

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws InterruptedException {
        zk.close();
    }

    void runForMaster() {
        while (true) {
            try {
                zk.create("/master", serverId.getBytes(), OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (checkMaster()) break;
        }
    }

    boolean checkMaster() {
        while (true) {
            try {
                Stat stat = new Stat();
                byte data[] = zk.getData("/master", false, stat);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                return false;
            } catch (InterruptedException e) {

            } catch (KeeperException e) {

            }
        }
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
