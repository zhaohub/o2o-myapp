package com.test.lock;

import redis.clients.jedis.Jedis;

/**
 * 基于redis的分布式锁实现
 * Created by zhaogang3 on 2017/1/18.
 */
public class DistributedLock {

    private Jedis jedis = new Jedis("test.redis.host");

    private Thread ownerThread;

    public DistributedLock() {
    }

    public DistributedLock(Thread ownerThread) {
        this.ownerThread = ownerThread;
    }

    public DistributedLock(Jedis jedis, Thread ownerThread) {
        this.jedis = jedis;
        this.ownerThread = ownerThread;
    }

    /**
     * 获取锁
     *
     * @param key
     * @param retryCount
     * @param waitTime
     * @return
     */
    public synchronized boolean tryLock(String key, int retryCount, int waitTime) {
        if (ownerThread != null && !ownerThread.equals(Thread.currentThread()))
            return false;
        else
            ownerThread = Thread.currentThread();

        int i = 0;
        while (i < retryCount) {
            Long r = jedis.setnx(key, String.valueOf(System.currentTimeMillis()));
            if (r > 0) {
                jedis.expire(key, 60);
                return true;
            } else {
                i++;
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {

                }
            }
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param key
     * @return
     */
    public synchronized boolean unLock(String key) {
        boolean res = false;
        if (ownerThread != null && ownerThread.equals(Thread.currentThread())) {
            jedis.del(key);
            res = true;
        }
        ownerThread = null;
        return res;
    }

}
