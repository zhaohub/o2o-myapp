package com.test.jvm;

/**
 * Created by zhaogang3 on 2016/7/25.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length" + oom.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

}
