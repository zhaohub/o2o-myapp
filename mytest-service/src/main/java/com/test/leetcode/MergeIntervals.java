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

        return mergeIntervals(intervals);
    }

    public static boolean hasIntervals(List<Interval> intervals) {
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.getEnd() >= cur.getStart())
                return true;

        }
        return false;
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();

        if (!hasIntervals(intervals))
            return intervals;

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval t;
            if (pre.getEnd() >= cur.getStart() && pre.getEnd() < cur.getEnd()) {
                t = new Interval(pre.getStart(), cur.getEnd());
            } else if (pre.getEnd() >= cur.getStart() && pre.getEnd() >= cur.getEnd()) {
                t = new Interval(pre.getStart(), pre.getEnd());
            } else {
                t = new Interval(cur.getStart(), cur.getEnd());
            }
            res.add(t);
            pre = cur;
        }
        return mergeIntervals(res);
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 11);
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
    int start;  //start must lower than end
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        if (s >= e)
            throw new IllegalArgumentException("start must lower than end");
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
