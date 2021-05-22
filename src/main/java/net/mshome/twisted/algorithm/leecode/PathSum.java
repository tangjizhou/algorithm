package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 路径总和
 *
 * @author tangjizhou
 * @since 2021/5/22
 */
public class PathSum {

    @Test
    public void test() {
        Assert.assertTrue(hasPathSumDFS(new TreeNode(1), 1));
        Assert.assertTrue(hasPathSumBFS(new TreeNode(1), 1));
    }

    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    if (poll.val == targetSum) return true;
                }
                if (poll.left != null) {
                    poll.left.val = poll.val + poll.left.val;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = poll.val + poll.right.val;
                    queue.add(poll.right);
                }
            }
        }
        return false;
    }

    public boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSumDFS(root.left, targetSum - root.val) || hasPathSumDFS(root.right, targetSum - root.val);
    }

}
