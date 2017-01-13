package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/12.
 */
public class PartitionList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode cur = head;
        ListNode lowPre = new ListNode(0), lowHead = lowPre;
        ListNode highPre = new ListNode(0), highHead = highPre;
        while (cur != null) {
            if (cur.val < x) {
                lowPre.next = cur;
                lowPre = lowPre.next;
            } else {
                highPre.next = cur;
                highPre = highPre.next;
            }
            cur = cur.next;
        }
        lowPre.next = highHead.next;
        highPre.next = null;
        return lowHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode n = partition(n1, 3);
    }

}
