package net.mshome.twisted.algorithm.leecode.S002;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(6);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        ListNode node24 = new ListNode(4);
        ListNode node25 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        print(addTwoNumbers(node11, node21));
        System.out.println();
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node1 = l1, node2 = l2, head = new ListNode(0), last = head, current = null;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;
            if (sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current = new ListNode(sum);
            last.next = current;
            last = current;

            node1 = node1.next;
            node2 = node2.next;
        }


        while (node1 != null) {
            int value = node1.val;
            value += carry;
            carry = 0;
            int sum = 0;
            if (value >= 10) {
                sum = value % 10;
                carry = 1;
            } else {
                sum = value;
            }
            current = new ListNode(sum);
            last.next = current;
            last = current;
            node1 = node1.next;
        }

        while (node2 != null) {
            int value = node2.val;
            value += carry;
            carry = 0;
            int sum = 0;
            if (value >= 10) {
                sum = value % 10;
                carry = 1;
            } else {
                sum = value;
            }
            current = new ListNode(sum);
            last.next = current;
            last = current;
            node2 = node2.next;
        }

        if (carry != 0) {
            current = new ListNode(1);
            last.next = current;
        }


        return head.next;
    }

    private static void print(ListNode node) {
        ListNode node1 = node;
        while (node1 != null) {
            System.out.print(node1.val);
            node1 = node1.next;
        }
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}