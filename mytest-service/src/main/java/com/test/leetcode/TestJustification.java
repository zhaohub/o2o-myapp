package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/29.
 */
public class TestJustification {

    /**
     * 1.先确定每一行的单词
     * 2.再确定单次之间的空格
     * 3.末行单独处理
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();

        int n = words.length, i = 0;

        while (i < n) {
            int len = words[i].length();   //length of each word
            int j = i + 1;

            String line = "";
            if (i == n - 1) {   //handle last word
                line += words[i];
                int space = maxWidth - len;
                while (space-- > 0)
                    line += " ";
            } else {
                while (j < n) {
                    len += 1 + words[j].length();
                    if (len > maxWidth) {
                        len -= 1 + words[j].length();
                        j = j - 1;
                        break;
                    }
                    j++;
                }

                int spaceCount = j - i;  //space count between all words
                int needSpace = maxWidth - len + spaceCount;  // all white space count;

                int k = i;
                for (; k < j; k++) {
                    line += words[k];
                    int s;
                    if (k == i)  //left slots assigned more space
                        s = needSpace % spaceCount + needSpace / spaceCount;
                    else
                        s = needSpace / spaceCount;

                    while (s-- > 0)
                        line += " ";
                }
                line += words[k];
            }
            res.add(line);
            i = j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = fullJustify(words, 16);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
