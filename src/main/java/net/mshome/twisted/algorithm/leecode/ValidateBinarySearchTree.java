package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/3/29
 */
public class ValidateBinarySearchTree {

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = null;
        TreeNode treeNode5 = null;
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        // Assert.assertFalse(isValidBST(treeNode1));

        treeNode1 = new TreeNode(1);
        treeNode2 = new TreeNode(1);
        treeNode1.left = treeNode2;
        Assert.assertFalse(isValidBST(treeNode1));
    }

    public boolean isValidBST(TreeNode root) {
        // return isValidBST(root, null, null);
        return inorder(root);
    }

    public boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        if (!isValidBST(root.left, root.val, min)) {
            return false;
        }
        if (!isValidBST(root.right, max, root.val)) {
            return false;
        }
        return true;
    }




    public boolean inorder(TreeNode root) {
        Integer lastValue = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            if (lastValue != null && lastValue >= root.val) {
                return false;
            }
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }


    // Definition for a binary tree node.
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


}
