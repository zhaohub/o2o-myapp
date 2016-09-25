package com.test.leetcode;

import java.util.Stack;

/**
 * Created by zhaogang3 on 2016/9/25.
 */
public class ValidParentheses {


    /**
     * 用栈实现
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(c);
            } else {
                int a = Math.abs(stack.peek() - c);
                if (a == 1 || a == 2) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size() == 0;
    }


    public static void main(String[] args) {
        String s = "{()[(])}";
        System.out.println(isValid(s));
    }
}
