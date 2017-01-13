package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/25.
 */
public class SwapNodesinPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode node = head, prev = tmp;
        while (node.next != null) {
            ListNode next = node.next;
            //swap current and success node
            node.next = node.next.next;
            prev.next = next;
            next.next = node;

            prev = next.next;
            node = next.next.next;
        }
        return tmp.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
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
        ListNode n = swapPairs(n1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
