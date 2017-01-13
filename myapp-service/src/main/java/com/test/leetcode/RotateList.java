package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/10/27.
 */
public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k <= 0) return head;

        int n = 0;
        ListNode cur = head, last = null;
        while (cur != null) {
            n++;
            last = cur;
            cur = cur.next;
        }

        k = n - k % n;
        cur = head;
        while (cur != null) {
            if (--k == 0) {
                last.next = head;
                head = cur.next;
                cur.next = null;
                break;
            }
            cur = cur.next;
        }
        return head;
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

        ListNode res = rotateRight(n1, 1002);
        printList(res);
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }
}
