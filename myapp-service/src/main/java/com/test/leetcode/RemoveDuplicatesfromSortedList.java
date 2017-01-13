package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/11/11.
 */
public class RemoveDuplicatesfromSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, cur = head.next;

        while (cur != null) {
            if (cur.val == pre.val) { //remove cur node
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode n = deleteDuplicates(n1);
    }
}
