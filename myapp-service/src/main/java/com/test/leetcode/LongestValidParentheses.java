package com.test.leetcode;

import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/9/29.
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty())
                    left = i;
                else {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(max, i - left) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()(()";
        System.out.println(longestValidParentheses(s));
    }
}