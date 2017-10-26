package com.test.lang;


import org.apache.commons.lang.StringUtils;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by zhaogang3 on 2017/2/16.
 */
public class Test1 {

    public static void main(String[] args){
        /*BigInteger r = fac(10000);

        System.out.println(r.bitLength());*/

        Long[] a = {12333L,1232432L,12412L};
        Long[] b = {12333L,1232432L,12412L};

        String aa = Arrays.toString(a);
        String bb= Arrays.toString(b);

        System.out.println(aa.equals(bb));
    }


    private static BigInteger fac(int f){
        if(f <=1){
            BigInteger integer = new BigInteger("1");
            return integer;
        }
        return fac(f-1).multiply(new BigInteger(String.valueOf(f)));
    }
}
