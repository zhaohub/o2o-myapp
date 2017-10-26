package com.test.lang;

/**
 * Created by zhaogang3 on 2017/8/2.
 */
public class Singleton {

    private Singleton(){
    }

    public static Singleton getInstance(){
        return InstanceHolder.instance;
    }

    static class InstanceHolder{
        private static Singleton instance = new Singleton();
    }


}
