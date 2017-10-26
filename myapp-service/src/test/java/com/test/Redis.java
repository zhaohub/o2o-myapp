package com.test;

import redis.clients.jedis.*;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaogang3 on 2017/5/10.
 */
public class Redis {

    private static final String REDIS_KEY_PREFIS = "redis_key_prefix_";

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws UnsupportedEncodingException {
        Jedis jedis = new Jedis("127.0.0.1");
        String key = "key_test";

        jedis.setex(key,11111111,"22222");
        System.out.println(jedis.ttl(key));
        jedis.set(key,"342432");
        System.out.println(jedis.ttl(key));


        /*for (int i = 0; i < 10000; i++) {
            *//*jedis.set(key + String.valueOf(i), String.valueOf(i) + "value");
            jedis.del(key + String.valueOf(i));*//*
            jedis.sadd(key,String.valueOf(i));
        }

        //scan all
        String cursor = "0";

        do {
            ScanResult<String> result = jedis.sscan(key,cursor);
            if (result != null) {
                cursor = result.getStringCursor();
                List<String> list = result.getResult();
                for (String k : list) {
                    System.out.println("cursor:"+cursor+"-"+k);
                }
            } else {
                cursor = "0";
            }

        } while (!"0".equals(cursor));*/


        /*jedis.del(key);
        Object o = jedis.eval("local nums = 0\n" +
                "for i = 0,100 do\n" +
                "\tnums=nums+1\n" +
                "\tredis.call('set','foo'..i,'bar'..i);\n" +
                "end\n" +
                "return nums");

        System.out.println(o);

        for (int i = 0; i < 100; i++) {
            System.out.println(jedis.get("foo" + i));
        }*/

        /*String[] arr = {"1111", "22222", "3333", "44444", "555555", "66666", "777777"};

        jedis.lpush(key, arr);

        List<String> list = jedis.lrange(key, 0, -1);
        for (String s : list) {
            System.out.println(s);
        }*/
    }

    private static void testCluster() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxWaitMillis(10000);

        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.1.122", 30001));

        final JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        for (int i = 0; i < 10; i++) {
            final int a = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long totalStart = System.currentTimeMillis();

                    int keyCount = 0;
                    for (int j = 0; j < Integer.MAX_VALUE; j++) {
                        keyCount++;
                        long start = System.currentTimeMillis();
                        cluster.set(REDIS_KEY_PREFIS + a + j, String.valueOf(j));
                        System.out.println("第" + j + "个key,用时" + (System.currentTimeMillis() - start) + "毫秒");
                    }
                    System.out.println("平均用时" + (System.currentTimeMillis() - totalStart) / keyCount + "毫秒");
                }
            });
        }
    }
}
