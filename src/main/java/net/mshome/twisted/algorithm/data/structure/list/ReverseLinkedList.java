package net.mshome.twisted.algorithm.data.structure.list;

import java.util.Objects;

/**
 * 反转链表
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/14
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
        print(reverse(node1));
    }


    private static class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static Node reverse(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        if (Objects.isNull(node.next)) {
            return node;
        }
        Node pre = null, current = node, next = current.next;
        while (next != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

}
