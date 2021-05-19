package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/27
 */
public class SameTree {

    @Test
    public void test() {
        TreeNode pRoot = new TreeNode(0);
        pRoot.left = new TreeNode(1);
        pRoot.right = new TreeNode(2);

        TreeNode qRoot = new TreeNode(0);
        qRoot.left = new TreeNode(1);
        qRoot.right = new TreeNode(1);

        Assert.assertTrue(isSameTreeBFS(pRoot, qRoot));
    }


    // DFS
    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right) && p.val == q.val;
    }

    // BFS
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pNodes = new LinkedList<>();
        LinkedList<TreeNode> qNodes = new LinkedList<>();
        pNodes.offer(p);
        qNodes.offer(q);

        while (!pNodes.isEmpty() && !qNodes.isEmpty()) {
            TreeNode pNode = pNodes.poll();
            TreeNode qNode = qNodes.poll();
            if (pNode == null || qNode == null) {
                if (pNode == qNode) {
                    continue;
                }
                return false;
            }
            if (pNode.left != null || qNode.left != null) {
                pNodes.offer(pNode.left);
                qNodes.offer(qNode.left);
            }
            if (pNode.right != null || qNode.right != null) {
                qNodes.offer(qNode.right);
                pNodes.offer(pNode.right);
            }
            if (pNode.val != qNode.val) {
                return false;
            }
        }
        return true;
    }


}

