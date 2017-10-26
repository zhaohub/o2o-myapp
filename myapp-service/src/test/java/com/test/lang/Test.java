package com.test.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by zhaogang3 on 2016/6/21.
 */
public class Test {
    static void say(){
        System.out.println(1111);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*Map map = new HashMap();
        map.put("test1", "test1");
        map.put("test2", "test2");
        MyMap myMap = new MyMap(map.entrySet());

        System.out.println(myMap.get("test1"));
        System.out.println(myMap.containsKey("test1"));*/

        /*BigInteger bigInteger = new BigInteger("9");
        System.out.println(bigInteger.pow(81).toString());
        //196627050475552913618075908526912116283103450944214766927315415537966391196809
        Test test = null;
        test.say();*/

        /*Long l = Long.parseLong("705077137000042");

        System.out.println(Integer.MAX_VALUE);

        System.out.println(captureName("book"));*/
        Singleton obj = Singleton.getInstance();


        /*Constructor<?> cons = Singleton.class.getDeclaredConstructor(null);

        cons.setAccessible(true);

        Singleton obj2 = (Singleton) cons.newInstance();
*/

        System.out.println(Long.MAX_VALUE);
    }
}

class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
