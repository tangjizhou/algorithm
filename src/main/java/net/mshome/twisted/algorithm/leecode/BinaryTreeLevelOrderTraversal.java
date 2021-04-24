package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/4/24
 */
public class BinaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        node3.right = node2;
        levelOrder(node1);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!nodes.isEmpty()) {
            int children = nodes.size(), current = 0;
            List<Integer> currentLevelValues = new ArrayList<>();
            while (current < children) {
                root = nodes.poll();
                if (root == null) {
                    continue;
                }
                currentLevelValues.add(root.val);
                if (root.left != null) nodes.add(root.left);
                if (root.right != null) nodes.add(root.right);
                ++current;
            }
            result.add(currentLevelValues);
        }
        return result;
    }

}
