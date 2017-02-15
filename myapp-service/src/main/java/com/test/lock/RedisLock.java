package com.test.lock;

import redis.clients.jedis.Jedis;

/**
 * Created by zhaogang3 on 2017/2/15.
 */
public class RedisLock {

    private Jedis jedis = new Jedis("test.redis.host");

    public RedisLock() {
    }

    public RedisLock(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 当前线程是否持有锁
     */
    private volatile boolean locked = false;

    /**
     * 获取锁
     *
     * @param key
     * @param retryCount
     * @param waitTime
     * @return
     */
    public boolean tryLock(String key, int retryCount, int waitTime) {

        int i = 0;
        while (i < retryCount) {
            Long r = jedis.setnx(key, String.valueOf(System.currentTimeMillis()));
            if (r > 0) {
                jedis.expire(key, 60);
                locked = true;
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
    public void unLock(String key) {
        if (locked) {
            jedis.del(key);
            locked = false;
        }
    }
}
