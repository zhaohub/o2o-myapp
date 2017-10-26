package com.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zhaogang3 on 2017/5/27.
 */
public class Container {
    ConcurrentMap<String, Object> map = new ConcurrentHashMap<String, Object>();

    public Object getObject(String key) {
        if (key == null)
            throw new NullPointerException();

        map.putIfAbsent(key, new Object());
        return map.get(key);
    }
}
