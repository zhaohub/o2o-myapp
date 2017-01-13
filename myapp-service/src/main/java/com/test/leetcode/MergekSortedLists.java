package com.test.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaogang3 on 2016/9/25.
 */
public class MergekSortedLists {

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);

        int length = lists.size();
        int mid = (length - 1) / 2;
        //二路归并
        ListNode l1 = mergeKLists(lists.subList(0, mid + 1));
        ListNode l2 = mergeKLists(lists.subList(mid + 1, length));
        return mergeTwoList(l1, l2);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n22 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n31 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n22;
        n22.next = n3;
        n31.next = n4;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        ListNode res = mergeKLists(Arrays.asList(n1, n31, n7));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
