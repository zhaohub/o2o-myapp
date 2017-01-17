package com.test.spring;

/**
 * Created by zhaogang3 on 2017/1/13.
 */
public class ClassA {

    private String name;

    private ClassB classB;

    public ClassA() {
    }

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
