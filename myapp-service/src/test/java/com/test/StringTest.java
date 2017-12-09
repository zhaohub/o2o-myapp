package com.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhaogang3 on 2017/12/9.
 */
public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bs10 = {-27, -109, -120};

        //java的byte是有符号的，第一位是符号位，可表示的整数范围为-128~127
        //十六进制
        //byte[] bs16 = {0xffffffe5,‭0xFFFfff93‬;‭0xFFFFFFFFFFFFFF88‬};

        String s = new String(bs10, "utf8");
        System.out.println(s);


        //"e5 93 88" utf8
        //System.out.println(ArrayUtils.toString("哈".getBytes("utf8")));
        //{-27,-109,-120}
    }
}
