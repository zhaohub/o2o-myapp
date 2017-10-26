package com.test.lang;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2017/9/12.
 */
public class HashMapTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
            list.add(t);
        }
        /*System.setProperty("user.timezone","GMT +01");
        long time = new Date().getTime();
        //System.out.println(new Date().getTimezoneOffset());
        System.out.println(time/1000%86400/3600);*/
    }
}
