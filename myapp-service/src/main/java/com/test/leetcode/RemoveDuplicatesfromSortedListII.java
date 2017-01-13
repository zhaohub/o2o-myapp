package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/11.
 */
public class RemoveDuplicatesfromSortedListII {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, cur = head.next;
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode h = tempHead;
        int count = 1;

        while (cur != null) {
            if (pre.val == cur.val) {
                count++;
            } else {
                if (count >= 2)   //delete duplicates
                    h.next = cur;
                else
                    h = pre;

                count = 1;
            }
            pre = cur;
            cur = cur.next;
        }
        if (count >= 2) h.next = null;  //remove tail duplicates
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode n = deleteDuplicates(n1);
    }
}
