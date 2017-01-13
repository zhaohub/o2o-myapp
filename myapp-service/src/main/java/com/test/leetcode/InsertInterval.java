package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/10/25.
 */
public class InsertInterval {

    static class Interval {
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

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }


    /**
     * complexity o(n)
     * find the overlapping intervals with newInterval and merge them
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //check parameter

        List<Interval> res = new ArrayList<Interval>();
        int i = 0, size = intervals.size();
        //before
        while (i < size && intervals.get(i).end < newInterval.start)
            res.add(intervals.get(i++));

        //overlapping
        while (i < size && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        //after
        while (i < size)
            res.add(intervals.get(i++));

        return res;
    }

    public static void main(String[] args) {
        /*Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 9);
        Interval newInt = new Interval(2, 5);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i1);
        list.add(i2);*/

        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(3, 5);
        Interval i3 = new Interval(6, 7);
        Interval i4 = new Interval(8, 10);
        Interval i5 = new Interval(12, 16);
        Interval newInt = new Interval(4, 9);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);

        List<Interval> res = insert(list, newInt);
        for (Interval t : res) {
            System.out.println(t);
        }
    }
}
