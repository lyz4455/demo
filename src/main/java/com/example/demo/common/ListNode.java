package com.example.demo.common;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-12 14:20
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
