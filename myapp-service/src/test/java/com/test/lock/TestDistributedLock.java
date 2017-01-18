package com.test.lock;

/**
 * Created by zhaogang3 on 2017/1/18.
 */
public class TestDistributedLock {

    public static void main(String[] args) {
        DistributedLock lock = new DistributedLock(Thread.currentThread());

        String key = "";

        try {
            lock.tryLock(key, 3, 20);


        } finally {
            lock.unLock(key);
        }

    }

}
