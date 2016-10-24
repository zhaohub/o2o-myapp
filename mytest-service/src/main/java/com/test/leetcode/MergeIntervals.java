package com.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/24.
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return null;

        //sort by start field
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() > o2.getStart() ? 1 : -1;
            }
        });

        List<Interval> res = new ArrayList<Interval>();

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.getEnd() >= cur.getStart()) {
                Interval t = new Interval(pre.getStart(), cur.getEnd());
                res.add(t);
            } else {
                Interval tt = new Interval(cur.getStart(), cur.getEnd());
                res.add(tt);
            }
            pre = cur;
        }

        return res;
    }


    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

        List<Interval> is = new ArrayList<Interval>();
        is.add(i4);
        is.add(i1);
        is.add(i2);
        is.add(i3);


        List<Interval> res = merge(is);
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

}
