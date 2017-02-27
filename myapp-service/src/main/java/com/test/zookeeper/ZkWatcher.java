package com.test.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by zhaogang3 on 2017/2/25.
 */
public class ZkWatcher implements Watcher {


    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("ZkWatcher->process path=" + watchedEvent.getPath());
    }
}
