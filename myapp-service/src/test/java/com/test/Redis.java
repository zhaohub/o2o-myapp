package com.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhaogang3 on 2017/5/10.
 */
public class Redis {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] a = new byte[]{'a',3,4,5,'b',7};
        jedis.set(a,a);
        jedis.set("aaaa","111");
        String aaaa = new String(a,"iso-8859-1");
        String b = jedis.get(aaaa);
        System.out.println(b);
    }

}
