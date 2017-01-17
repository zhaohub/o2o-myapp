package com.test.spring;

/**
 * Created by zhaogang3 on 2017/1/13.
 */
public class ClassC {

    private String name;

    private ClassA classA;

    public ClassC() {
    }

    public ClassC(ClassA classA) {
        this.classA = classA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassA getClassA() {
        return classA;
    }

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
