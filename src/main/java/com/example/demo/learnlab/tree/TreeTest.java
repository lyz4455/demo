package com.example.demo.learnlab.tree;

import com.example.demo.common.TreeNode;
import com.example.demo.common.TreeUtil;

import java.util.*;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-13 12:47
 */
public class TreeTest {

    /**
     * 二叉树的广度遍历
     * 用到了队列  TreeNode按照root left right的顺序放入queue;
     *
     * @param root
     * @return
     */
    public static List<Integer> breadthSearch(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }

    /**
     * 二叉树的深度遍历
     * 用到了栈 TreeNode按照 root 弹出, right left的顺序放入stack;
     *
     * @param root
     * @return
     */
    public static List<Integer> depthSearch(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            res.add(temp.val);
        }
        return res;
    }

    /**
     * 二叉树的中序遍历  递归
     * 前序遍历：打印 - 左 - 右  Preorder traversal
     * 中序遍历：左 - 打印 - 右  inorder Traversal
     * 后序遍历：左 - 右 - 打印  Postorder traversal
     */
    public static List<Integer> treeSearch(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        mid(root, res);
        return res;
    }

    static void mid(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        mid(root.left, res);
        res.add(root.val);
        mid(root.right, res);
    }

    static void pre(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        pre(root.left, res);
        pre(root.right, res);
    }

    static void after(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }

        pre(root.left, res);
        pre(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        TreeNode root = TreeUtil.createTree(arr);
        List<Integer> integerList = TreeTest.treeSearch(root);
        System.out.println(integerList);
    }
}
