package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 *
 * @author tangjizhou
 * @since 2021/5/19
 */
public class MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        Assert.assertEquals(0, minDepthBFS(null));
        Assert.assertEquals(0, minDepthDFS(null));
        Assert.assertEquals(1, minDepthBFS(new TreeNode(1)));
        Assert.assertEquals(1, minDepthDFS(new TreeNode(1)));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(2, minDepthBFS(root));
        Assert.assertEquals(2, minDepthDFS(root));
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }


    public int minDepthDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth = Integer.MAX_VALUE;
        if (root.left != null) depth = Math.min(minDepthDFS(root.left), depth);
        if (root.right != null) depth = Math.min(minDepthDFS(root.left), depth);
        return depth + 1;
    }

}
