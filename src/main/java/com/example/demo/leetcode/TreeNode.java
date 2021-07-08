package com.example.demo.leetcode;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-08 19:12
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
