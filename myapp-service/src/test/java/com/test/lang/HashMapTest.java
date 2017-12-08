package com.test.lang;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2017/9/12.
 */
public class HashMapTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        /*for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
            list.add(t);
        }*/
        /*System.setProperty("user.timezone","GMT +01");
        long time = new Date().getTime();
        //System.out.println(new Date().getTimezoneOffset());
        System.out.println(time/1000%86400/3600);*/

        //System.out.println(StringUtils.remove(UUID.randomUUID().toString(),"-").toUpperCase());

        String s = null;

        try {
            byte[] s1111 = Base64.encodeBase64("aaaaaabbbbbbb".getBytes());
            System.out.println(new String(s1111));

            s1111 = Base64.decodeBase64(s1111);

            System.out.println(new String(s1111));

            System.out.println("--------------");

            s = URLEncoder.encode("aaaaaabbbbbbb", "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        try {
            System.out.println(URLDecoder.decode(s, "utf8"));

            String ss = "春节";
            byte[] bs = ss.getBytes("utf8");
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
