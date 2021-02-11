package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/12/27
 */
public class BinaryTreeInorderTraversal {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = List.of(2, 1, 3);
        List<Integer> list = inorderTraversalBFS(root);
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(result.get(i), list.get(i));
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalBFS(root);
        // List<Integer> list = new ArrayList<>();
        // inorderTraversalDFS(root, list);
        // return list;
    }


    public void inorderTraversalDFS(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversalDFS(root.left, list);
        list.add(root.val);
        inorderTraversalDFS(root.right, list);
    }

    public List<Integer> inorderTraversalBFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
