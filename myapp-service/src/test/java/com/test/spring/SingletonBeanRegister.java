package com.test.spring;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaogang3 on 2017/1/13.
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {

    private final Map<String, Object> beans = new ConcurrentHashMap<String, Object>();


    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        if (!beans.containsKey(beanName))
            beans.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return beans.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return beans.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return beans.keySet().toArray(new String[0]);
    }

    @Override
    public int getSingletonCount() {
        return 0;
    }
}
