package com.test;

import redis.clients.jedis.Jedis;

/**
 * Created by zhaogang3 on 2017/10/11.
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");

        //string
        String stringKey = "redis-string";
        jedis.set(stringKey, "hello redis");
        jedis.append(stringKey, " 123");

        System.out.println(jedis.get(stringKey));

        System.out.println(jedis.strlen(stringKey));

        //jedis.geoadd("geo",132.24,24.42,"42");
    }
}
