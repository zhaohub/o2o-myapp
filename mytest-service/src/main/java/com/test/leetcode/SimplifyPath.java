package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/2.
 */
public class SimplifyPath {


    /**
     * simplify path
     *
     * @param path unix-style file path
     * @return
     */
    public static String simplifyPath(String path) {
        int n = path.length();
        //pre process
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = path.charAt(i);
            if (c == '/') {
                while (true) {
                    if (i < n - 1 && path.charAt(++i) != '/') {
                        i = i - 1;
                        break;
                    } else if (i >= n - 1)
                        break;
                }
            }
            sb.append(c);
        }

        if (sb.charAt(0) != '/')
            sb.insert(0, '/');

        int pre = 0, i = 1;
        while (i < n) {
            n = sb.length();
            if (i < n - 1 && sb.charAt(i) == '/') {
                String sub = sb.substring(pre + 1, i);
                if (".".equals(sub)) {
                    sb.delete(pre + 1, i + 1);
                    i = 0;
                }

                if ("..".equals(sub)) {
                    int j = i;
                    int count = 0;
                    while (true) {
                        j--;
                        if (sb.charAt(j) == '/')
                            count++;
                        if (count == 2)
                            break;
                    }
                    sb.delete(j + 1, i + 1);
                    i = 0;
                }
                pre = i;
            }
            i++;
        }

        if (sb.charAt(sb.length() - 1) == '/')
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
