package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/solution/er-cha-sou-suo-shu-de-fan-wei-he-by-leet-rpq7/
 * 二叉搜索树的范围和
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/4/27
 */
public class RangeSumOfBst {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        node3.right = node2;
        Assert.assertEquals(6, rangeSumBST(node1, 1, 3));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null || (high < low)) {
            return 0;
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
    }


}
