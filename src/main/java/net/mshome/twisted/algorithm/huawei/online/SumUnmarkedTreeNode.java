package net.mshome.twisted.algorithm.huawei.online;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的一条根到叶子节点到路径中如果存在一个点将路径分为和相等的2段，则进行标记，返回所有未标记段点的和
 *
 * @author tangjizhou
 * @since 2021/5/21
 */
public class SumUnmarkedTreeNode {


    private int markedSum = 0;
    private int total = 0;

    @Test
    public void test() {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(11);
        node.left.left.left.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(4);
        node.right.left.left = new TreeNode(1);
        node.right.left.right = new TreeNode(3);
        node.right.left.left.left = new TreeNode(16);
        Assert.assertEquals(49, sum(node));
    }

    public int sum(TreeNode root) {
        sumPathsAndMark(root, 0);
        return total - markedSum;
    }

    public List<Integer> sumPathsAndMark(TreeNode node, int sum) {
        if (node == null) {
            return Collections.emptyList();
        }
        total += node.val;
        List<Integer> sums = new ArrayList<>();
        List<Integer> leftSums = sumPathsAndMark(node.left, sum + node.val);
        List<Integer> rightSums = sumPathsAndMark(node.right, sum + node.val);
        if (leftSums.isEmpty() && rightSums.isEmpty()) {
            return List.of(node.val);
        }

        for (Integer leftSum : leftSums) {
            if (leftSum == sum) markedSum += node.val;
            sums.add(leftSum + node.val);
        }
        for (Integer rightSum : rightSums) {
            if (rightSum == sum) markedSum += node.val;
            sums.add(rightSum + node.val);
        }
        return sums;
    }


}
