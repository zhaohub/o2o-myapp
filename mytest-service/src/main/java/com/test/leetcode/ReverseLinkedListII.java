package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/13.
 */
public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) return head;

        ListNode cur = head, pre = new ListNode(0), subPre = pre, sub = pre, last = pre;
        int i = 1;
        while (cur != null) {
            ListNode t = cur, tNext = cur.next;

            if (i == m) {
                subPre = pre;
                last = cur;
            } else if (i > m && i <= n) {  //reverse nodes
                sub.next = cur;
                cur.next = pre;
            } else if (i == n + 1) {
                last.next = cur;
            }
            i++;
            pre = t;
            cur = tNext;
        }
        if (i == n + 1)
            last.next = null;
        subPre.next = sub.next;
        return m == 1 ? subPre.next : head;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode n = reverseBetween(n1, 1, 2);
    }
}
