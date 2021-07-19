package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 *
 * @author tangjizhou
 * @since 2021/7/16
 */
public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        ListNode newNode = removeNthFromEnd(node, 0);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode l = node, r = node;
        while (r.next != null && n != 0) {
            r = r.next;
            n = n - 1;
        }
        ListNode pre = l;
        while (r.next != null) {
            pre = l;
            l = l.next;
            r = r.next;
        }
        if (l.next == null) pre.next = null;
        else l.next = l.next.next;
        return node.next;
    }

}
