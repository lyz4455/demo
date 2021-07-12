package com.example.demo.common;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-08 19:12
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
