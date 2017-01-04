package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/12/19.
 */
public class ConvertSortedListtoBinarySearchTree {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private static TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {  //search the middle node
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = toBST(head, slow);
        treeHead.right = toBST(slow.next, tail);

        return treeHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        TreeNode tree = sortedListToBST(n1);
    }
}
