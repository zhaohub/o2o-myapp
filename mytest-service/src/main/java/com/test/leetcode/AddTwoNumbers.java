package com.test.leetcode;

/**
 * Created by zhaogang3 on 2016/9/15.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        int sum = l1.val + l2.val;
        int carry = 0;
        if (sum > 10) {
            carry = 1;
            sum = sum - 10;
        }
        ListNode head = new ListNode(sum);
        ListNode rs = head;
        do {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                l2.val += carry;
                rs.next = l2;
                break;
            }
            if (l2 == null) {
                l1.val += carry;
                rs.next = l1;
                break;
            }
            if ((sum = l1.val + l2.val + carry) > 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            rs.next = new ListNode(sum);
            rs = rs.next;
        } while (true);
        return head;
    }

    /**
     * 评论区中的解法
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode rs = head;
        while (l1 != null || l2 != null) {
            sum = sum / 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            rs.next = new ListNode(sum % 10);
            rs = rs.next;
        }
        if (sum / 10 == 1)
            rs.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(2);
        a1.next = a2;
        a2.next = a5;
        a4.next = a3;
        a3.next = a6;
        a6.next = a7;
        System.out.println(convertListNodeToString(a1));
        System.out.println(convertListNodeToString(a4));
        System.out.println(convertListNodeToString(addTwoNumbers2(a1, a4)));
    }

    private static String convertListNodeToString(ListNode node) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder("");
        while (node != null) {
            if (node.next == null) {
                sb.append(node.val);
            } else {
                sb.append(node.val + "->");
            }
            node = node.next;
        }
        return sb.toString();
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}

