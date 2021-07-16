package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 链表的中间结点
 *
 * @author tangjizhou
 * @since 2021/7/16
 */
public class MiddleOfTheLinkedList {

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        // node.next.next.next.next.next.next = new ListNode(7);
        Assert.assertEquals(4, middleNode(node).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode l = head, r = head;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        return l;
    }

}
