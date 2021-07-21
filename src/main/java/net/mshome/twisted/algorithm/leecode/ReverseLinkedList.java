package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class ReverseLinkedList {

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        final ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
