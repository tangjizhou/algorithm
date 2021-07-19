package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 合并二叉树
 *
 * @author tangjizhou
 * @since 2021/7/19
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = null;
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;

    }

}
