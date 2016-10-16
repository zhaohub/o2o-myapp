package com.test.leetcode;

import java.util.*;

/**
 * Created by zhaogang3 on 2016/10/15.
 */
public class GroupAnagrams {

    /**
     * need optimize
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();

        Map<String, String> map = new HashMap<String, String>();
        Set<String> keys = new HashSet<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            map.put(strs[i], Arrays.toString(chars));
            keys.add(Arrays.toString(chars));
        }

        for (String s : keys) {
            List<String> group = new ArrayList<String>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (s.equals(entry.getValue()))
                    group.add(entry.getKey());
            }
            res.add(group);
        }
        return res;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        Map<String, List<String>> res = new HashMap<String, List<String>>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (res.containsKey(key))
                res.get(key).add(s);
            else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                res.put(key, list);
            }
        }
        return new ArrayList<List<String>>(res.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams2(strs);
        for (List<String> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
