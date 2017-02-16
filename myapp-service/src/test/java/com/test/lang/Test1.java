package com.test.lang;

/**
 * Created by zhaogang3 on 2017/2/16.
 */
public class Test1 {


    public static void main(String[] args) {

        try {
            if (1 == 1)
                throw new RuntimeException();

        } finally {

        }
        System.out.println(111);
    }

}
