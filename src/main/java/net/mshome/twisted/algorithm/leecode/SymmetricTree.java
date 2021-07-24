package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/4/3
 */
public class SymmetricTree {


    class Solution {

        public boolean isSymmetric(TreeNode root) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            return isSameDFS(left, right);
        }

        public boolean isSameDFS(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && isSameDFS(left.left, right.right) && isSameDFS(left.right, right.left);
        }

        public boolean isSameBFS(TreeNode left, TreeNode right) {

            return false;

        }

    }

}
