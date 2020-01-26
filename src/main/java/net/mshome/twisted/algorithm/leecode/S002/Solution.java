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
        ListNode node1 = l1, node2 = l2, head = new ListNode(0), current = head;
        while (node1 != null || node2 != null) {
            node1 = node1 == null ? new ListNode(0) : node1;
            node2 = node2 == null ? new ListNode(0) : node2;

            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;

            node1 = node1.next;
            node2 = node2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
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