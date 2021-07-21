package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 *
 * @author tangjizhou
 * @since 2021/7/20
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return head.next;
    }

}
