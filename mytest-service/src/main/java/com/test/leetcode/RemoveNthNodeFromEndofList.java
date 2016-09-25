package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/24.
 */
public class RemoveNthNodeFromEndofList {

    /**
     * 快慢指针法
     *
     * @param head
     * @param n    链表末尾n=1
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n <= 0) return head;
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode fast = tmpHead;
        ListNode slow = tmpHead;

        while (fast.next != null) {
            if (n <= 0) //距离小于等于0时，慢指针开始移动
                slow = slow.next;
            fast = fast.next;
            --n;
        }
        if (n > 0) return tmpHead.next;
        if (slow.next != null)
            slow.next = slow.next.next;
        return tmpHead.next;
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
        ListNode n = removeNthFromEnd(n1, 5);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
