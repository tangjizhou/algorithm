package net.mshome.twisted.algorithm.data.structure;

/**
 * 链表节点
 *
 * @author tangjizhou
 * @since 2021/7/8
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
