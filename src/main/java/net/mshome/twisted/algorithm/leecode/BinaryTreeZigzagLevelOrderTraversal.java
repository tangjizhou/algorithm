package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 二叉树的锯齿形层序遍历
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/4/25
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        zigzagLevelOrder(node1);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean l2r = true;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size(), current = 0;
            List<Integer> arr = new ArrayList<>();
            while (current < size) {
                TreeNode node = null;
                if (l2r) {
                    node = queue.pollFirst();
                    if (node.left != null) queue.offerLast(node.left);
                    if (node.right != null) queue.offerLast(node.right);
                } else {
                    node = queue.pollLast();
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
                arr.add(node.val);
                ++current;
            }
            l2r = !l2r;
            result.add(arr);
        }
        return result;
    }


}
