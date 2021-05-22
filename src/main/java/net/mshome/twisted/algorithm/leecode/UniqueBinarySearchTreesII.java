package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/2/14
 */
public class UniqueBinarySearchTreesII {



    @Test
    public void test() {
        generateTrees(3);
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTrees(1, n);
    }


    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }

        }
        return allTrees;
    }


}
