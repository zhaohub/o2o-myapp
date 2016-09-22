package com.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/22.
 */
public class LetterCombinationsofaPhoneNumber {


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return null;
        //check digits are all digit?

        String[] buttons = {"︼", "ω", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - 48;
            if (result.size() == 0) {
                for (int j = 0; j < buttons[c].length(); j++) {
                    result.add(String.valueOf(buttons[c].charAt(j)));
                }
            } else {
                List<String> tmp = new ArrayList<String>();
                for (String s : result)
                    for (int j = 0; j < buttons[c].length(); j++)
                        tmp.add(s + String.valueOf(buttons[c].charAt(j)));

                result.clear();
                result.addAll(tmp);
            }
        }
        return result;
    }

    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        String[] mapping = {"︼", "ω", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char c : mapping[x].toCharArray()) {
                    res.add(t + c);
                }
            }
        }
        return res;
    }

    /**
     * time1:1764,size:2125764
     * time2:2400,size2125764
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String d = "2359834466634";
        List<String> r = letterCombinations(d);
        /*for (String s : r) {
            System.out.println(s);
        }*/
        long end = System.currentTimeMillis();
        List<String> r1 = letterCombinations2(d);
        System.out.println("time1:" + (end - start) + ",size:" + r.size());
        System.out.println("time2:" + (System.currentTimeMillis() - end) + ",size" + r1.size());
    }

}
