package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/26.
 */
public class ReverseNodesinkGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = head, prev = dummy;
        int count = 1;
        while (last != null) {
            ListNode tmp = last.next;
            if (count == k) {
                //reverse nodes
                reverseSubList(head, last);
                //change pointer to next group
                prev.next = last;
                prev = head;
                head.next = tmp;
                head = last = tmp;
                count = 1;
            } else {
                last = last.next;
                count++;
            }
        }
        return dummy.next;
    }

    private static void reverseSubList(ListNode head, ListNode tail) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode node = head;

        while (prev != tail) {
            ListNode tmp = node.next;
            node.next = prev;

            //move prev and current node
            prev = node;
            node = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode n = reverseKGroup(n1, 4);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
