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

    /**
     * 3
     */
    class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            int left = 0;
            int right = 1;
            int res = 1;
            int lenTem;
            while (right < s.length()) {
                int pos = s.indexOf(s.charAt(right), left);
                if (pos < right) {
                    int len = right - left;
                    if (len > res) {
                        res = len;
                    }
                    left = pos + 1;
                    right++;
                } else {
                    lenTem = right - left + 1;
                    right++;

                    if (lenTem > res) {
                        res = lenTem;
                    }
                }
            }
            return res;
        }
    }

    /**
     * 5
     */
    static class Solution5 {
        //        public static String longestPalindrome1(String s) {
//            if (s.length() < 2) {
//                return s;
//            }
//            int maxLen = 1;
//            int start = 0;
//            int end = 0;
//
//            int leftTemp;
//            int rightTemp;
//            int left;
//            int right;
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = s.length() - 1; j > 0; j--) {
//                    left = i;
//                    if (s.charAt(left) != s.charAt(j)) {
//                        continue;
//                    } else {
//                        right = j;
//                        leftTemp = left;
//                        rightTemp = right;
//                        if (right <= left) {
//                            continue;
//                        }
//                        while (left < right - 1) {
//                            left++;
//                            right--;
//                            if (left == right) {
//                                int len = rightTemp - leftTemp + 1;
//                                if (len > maxLen) {
//                                    start = leftTemp;
//                                    end = rightTemp;
//                                    maxLen = len;
//                                }
//                            }
//                            if (s.charAt(left) != s.charAt(right)) {
//                                break;
//                            }
//                        }
//                        if (left == right - 1) {
//                            if (s.charAt(left) != s.charAt(right)) {
//                                continue;
//                            }
//                            int len = rightTemp - leftTemp + 1;
//                            if (len > maxLen) {
//                                start = leftTemp;
//                                end = rightTemp;
//                                maxLen = len;
//                            }
//                        }
//                    }
//                }
//            }
//            return s.substring(start, end + 1);
//        }
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }
            int maxLen = 1;
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > maxLen) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                    maxLen = len;
                }

            }
            return s.substring(start, end + 1);

        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }

    /**
     * 7
     */
    static class Solution7 {
        public static int reverse(int x) {
            String c = Integer.toString(x);
            String res;
            if (x >= 0) {
                res = reverseStr(c);
            } else {
                c = c.substring(1);
                res = "-" + reverseStr(c);
            }
            try {
                return Integer.parseInt(res);
            }catch (Exception ex){
                return 0;
            }
        }

        public static String reverseStr(String x) {
            String res ="";
            for (int i = x.length() - 1; i >= 0; i--) {
                res += x.substring(i, i + 1);
            }
            return res;

        }

        public static void main(String[] args) {

            System.out.println(reverse(1534236469));
        }
    }
}
