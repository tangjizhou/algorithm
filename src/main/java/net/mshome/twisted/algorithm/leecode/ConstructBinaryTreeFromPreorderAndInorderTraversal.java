package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/5/8
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        preorder = new int[]{1, 2, 3};
        inorder = new int[]{3, 2, 1};
        TreeNode node = buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {

        if (preBegin > preEnd || inBegin > inEnd) return null;
        if (inBegin == inEnd) return new TreeNode(inorder[inEnd]);
        if (preBegin == preEnd) return new TreeNode(preorder[preEnd]);

        int root = preorder[preBegin];
        TreeNode node = new TreeNode(root);

        // 找到根结点
        int inMiddle = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (root == inorder[i]) {
                inMiddle = i;
                break;
            }
        }

        // 进行左右分段，将属于左子树的范围进行左子树构造，以长度进行左右子树的划分
        TreeNode left = buildTree(preorder, inorder, preBegin + 1, preBegin + inMiddle - inBegin, inBegin, inMiddle - 1);
        // 进行左右分段，将属于右子树的范围进行右子树构造，以长度进行左右子树的划分
        TreeNode right = buildTree(preorder, inorder, preBegin + inMiddle - inBegin + 1, preEnd, inMiddle + 1, inEnd);
        node.left = left;
        node.right = right;
        return node;
    }

}
