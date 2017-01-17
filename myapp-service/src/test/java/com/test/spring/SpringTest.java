package com.test.spring;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * Created by zhaogang3 on 2016/9/18.
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
        //MainTest test1 = context.getBean("test", MainTest.class);
        //MainTest test2 = context.getBean("test", MainTest.class);

        //ClassA a = (ClassA) context.getBean("a");


    }
}

class testReplace implements MethodReplacer{
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return null;
    }
}
