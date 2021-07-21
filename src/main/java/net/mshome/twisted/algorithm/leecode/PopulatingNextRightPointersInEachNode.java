package net.mshome.twisted.algorithm.leecode;


import net.mshome.twisted.algorithm.data.structure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针
 *
 * @author tangjizhou
 * @since 2021/7/19
 */
public class PopulatingNextRightPointersInEachNode {

    public Node dfs(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            dfs(root.left);
            dfs(root.right);
        }
        return root;
    }

    public Node connect(Node root) {
        Node levelFirst = root;
        while (levelFirst != null && levelFirst.left != null) {
            Node curr = levelFirst;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            levelFirst = levelFirst.left;
        }
        return root;
    }

    public Node bfs(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            Node curr = queue.poll();
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            for (int i = 0; i < size - 1; i++) {
                final Node next = queue.poll();
                curr.next = next;
                curr = next;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }

}
