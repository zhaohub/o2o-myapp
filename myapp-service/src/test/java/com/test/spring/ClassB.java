package com.test.spring;

/**
 * Created by zhaogang3 on 2017/1/13.
 */
public class ClassB {

    private String name;

    private ClassC classC;

    public ClassB() {
    }

    public ClassB(ClassC classC) {
        this.classC = classC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassC getClassC() {
        return classC;
    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }
}
