package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-02-22 17:06
 */
public class LeetcodeOne {

    /**
     * 1
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            int[] resArray = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int req = nums[i];
                int res = target - req;
                if (sumMap.get(res) != null) {
                    resArray[0] = i;
                    resArray[1] = sumMap.get(res);
                    return resArray;
                } else {
                    sumMap.put(req, i);
                }
            }
            return resArray;
        }
    }

    /**
     * 2
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int flag = 0;
            List<Integer> res1 = new ArrayList<>();
            while (l1 != null || l2 != null) {

                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;

                int val = n1 + n2 + flag;
                int temp = val % 10;
                if (val > 9) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                res1.add(temp);
                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (flag > 0) {
                res1.add(1);

            }
            ListNode head = new ListNode(res1.get(0));
            ListNode p = head;
            if (res1.size() > 1) {
                for (int i = 1; i < res1.size(); i++) {
                    ListNode node = new ListNode();
                    node.val = res1.get(i);
                    p.next = node;
                    p = node;
                }
            }
            return head;

        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}
