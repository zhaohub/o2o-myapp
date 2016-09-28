package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/28.
 */
public class SubstringwithConcatenationofAllWords {


    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0) return null;

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].length() != words[i].length()) {
                throw new IllegalArgumentException("each string of words must be the same length");
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        List<String> list = new ArrayList<String>();
        int wordLen = words[0].length(), len = words.length;
        int last = Integer.MAX_VALUE;
        for (int i = 0; i + wordLen < s.length(); i++) {
            String sub = s.substring(i, i + wordLen);
            for (String w : words) {
                if (w.equals(sub)) {
                    last = Math.min(last, i);
                    list.add(w);
                    break;
                }
            }
            //match one word
            if (list.size() == len && (i - last) == wordLen * (len - 1)) {
                res.add(i - wordLen * (len - 1));
                last = Integer.MAX_VALUE;
                list.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoobarbooman";
        String[] words = {"oo", "ab"};
        List<Integer> list = findSubstring(s, words);
    }
}
