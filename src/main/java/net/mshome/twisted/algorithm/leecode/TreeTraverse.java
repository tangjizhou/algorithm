package net.mshome.twisted.algorithm.leecode;

import net.mshome.twisted.algorithm.data.structure.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


/**
 * 树的遍历
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/14
 */
public class TreeTraverse {

    private TreeNode root;

    @Test
    public void preorderTraversal() {
        System.out.println(Arrays.toString(preorderDFS(root, new ArrayList<>()).toArray()));
        System.out.println(Arrays.toString(preorderBFS1(root).toArray()));
        System.out.println(Arrays.toString(preorderBFS2(root).toArray()));
        System.out.println(Arrays.toString(preorderBFS3(root).toArray()));
    }

    @Test
    public void inorderTraversal() {
        System.out.println(Arrays.toString(inorderDFS(root, new ArrayList<>()).toArray()));
        System.out.println(Arrays.toString(inorderBFS1(root).toArray()));
        System.out.println(Arrays.toString(inorderBFS2(root).toArray()));
        System.out.println(Arrays.toString(inorderBFS3(root).toArray()));
    }

    @Test
    public void postorderTraversal() {
        System.out.println(Arrays.toString(postorderDFS(root, new ArrayList<>()).toArray()));
        System.out.println(Arrays.toString(postorderBFS1(root).toArray()));
    }

    private List<Integer> postorderBFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            // 找到最左侧节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 弹出最左侧节点
            root = stack.pop();
            // 如果最左侧节点没有右节点或者 有右节点但是前一次遍历对就是右节点，则遍历当前节点
            // 因为根节点是最后遍历的，故遍历了当前节点之后，就应该遍历当前节点（当前节点没有左节点）的根节点
            // 所以将root设为空值，以让栈弹出当前节点的根结点
            if (root.right == null || pre == root.right) {
                pre = root;
                values.add(root.val);
                root = null;
            } else { // 如果右侧节点不为空，就继续往右走
                stack.push(root);
                root = root.right;
            }
        }
        return values;
    }

    private List<Integer> postorderDFS(TreeNode root, List<Integer> values) {
        if (root == null) {
            return Collections.emptyList();
        }
        postorderDFS(root.left, values);
        postorderDFS(root.right, values);
        values.add(root.val);
        return values;
    }

    private List<Integer> inorderBFS3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            values.add(root.val);
            root = root.right;
        }
        return values;
    }

    private List<Integer> inorderBFS2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if ((root = stack.peek()) != null) {
                stack.push(root.left);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    return values;
                }
                root = stack.pop();
                values.add(root.val);
                stack.push(root.right);
            }
        }
        return values;
    }

    private List<Integer> inorderBFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            values.add(root.val);
            root = root.right;
        }
        return values;
    }

    private List<Integer> inorderDFS(TreeNode root, List<Integer> values) {
        if (root == null) {
            return Collections.emptyList();
        }
        inorderDFS(root.left, values);
        values.add(root.val);
        inorderDFS(root.right, values);
        return values;
    }

    public List<Integer> preorderDFS(TreeNode root, List<Integer> values) {
        if (root == null) {
            return Collections.emptyList();
        }
        values.add(root.val);
        preorderDFS(root.left, values);
        preorderDFS(root.right, values);
        return values;
    }

    public List<Integer> preorderBFS1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                values.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return values;
    }

    public List<Integer> preorderBFS2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            // 向左走到底
            while ((root = stack.peek()) != null) {
                values.add(root.val);
                root = root.left;
                stack.push(root);
            }
            // 弹出最后一个空指针
            stack.pop();
            // 然后添加右子树
            if (!stack.isEmpty()) {
                root = stack.pop();
                stack.push(root.right);
            }
        }
        return values;
    }

    public List<Integer> preorderBFS3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                values.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return values;
    }

    @Before
    public void init() {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        root = treeNode1;
    }

}
