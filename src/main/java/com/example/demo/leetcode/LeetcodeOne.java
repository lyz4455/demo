package com.example.demo.leetcode;


import java.util.*;

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
     * 6
     */
    class Solution6 {
        public String convert(String s, int numRows) {
            int len = s.length();
            if (len <= numRows) {
                return s;
            }
            int turns = len / (numRows + numRows - 2);
            if (len % (numRows + numRows - 2) > 0) {
                turns++;
            }
            int column = turns * (numRows - 1);
            char[][] res = new char[numRows][column];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int ss = i % (numRows + numRows - 2);
                int turn = i / (numRows + numRows - 2);
                int preCol = (turn - 1) * (numRows - 1);
                if (ss < numRows) {
                    res[1][preCol] = chars[i];
                }

            }
            return null;
        }
    }

    /**
     * 7
     */
    static class Solution7 {
        public static int reverse(int x) {
            long res = 0;
            while (x != 0) {
                int b = x % 10;
                if (res * 10 + b > Integer.MAX_VALUE || res * 10 + b < Integer.MIN_VALUE) {
                    return 0;
                }
                res = res * 10 + b;
                x = x / 10;
            }
            return (int) res;
        }
    }

    /**
     * 151
     */
    static class Solution151 {

        public String reverseWords(String s) {
            List list = Arrays.asList(s.split(" "));
            String res = "";
            if (list != null) {
                int size = list.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (list.get(i) != null && !"".equals(list.get(i))) {
                        res += " " + list.get(i);
                    }
                }
                res = res.substring(1);
            }
            return res;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    /**
     * 226
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

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;

        }
    }

/**
 * 35
 */
static class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public static int binSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution35.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}

/**
 * 88
 */
class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

/**
 * 4
 */
static class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] r = new int[m + n];
        for (int i = 0; i < m; i++) {
            r[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            r[m + i] = nums2[i];
        }
        Arrays.sort(r);
        if (r.length % 2 == 0) {
            return (double) (r[r.length / 2 - 1] + r[r.length / 2]) / 2;
        } else {
            return r[(r.length - 1) / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}

/**
 * 11
 */
static class Solution11 {
    public static int maxArea(int[] height) {
        int right = height.length - 1;
        int res = 0;
        int left = 0;
        while (left < right) {
            int temp = Integer.min(height[left], height[right]) * (right - left);
            if (temp > res) {
                res = temp;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution11.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }
}/**
 * Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        int count = 0;
        while (index != null){
            count++;
            index = index.next;
        }
        if(count < n){
            return head;
        }
       ListNode yummy = new ListNode(0,head);
        int i = count - n + 1;
        ListNode pre = yummy;
        for (int j = 1; j < i ; ++j) {
            pre = pre.next;
        }
        ListNode temp = pre.next;
        pre.next = temp.next;
        return yummy.next;
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode ans = dummy.next;
            return ans;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}



    class Solution32 {

        public ListNode mergeKLists(ListNode[] lists) {
            int num = lists.length;
            ListNode temp = null;
            for (int i = 0; i < num; i++) {
                temp = mergeTwoLists(temp, lists[i]);
            }
            return temp;

        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            if (l1 == null) {
                pre.next = l2;
            } else {
                pre.next = l1;
            }
            return dummy.next;

        }

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

    class Solution206 {
        public ListNode reverseList(ListNode head) {

            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode left = head;
            ListNode right = head.next;
            head.next = null;
            while (right != null) {
                dummy.next = right;
                ListNode temp = right.next;
                right.next = left;
                left.next = null;
                right = temp;
                left = dummy.next;
            }
            return dummy.next;
        }
    }
}


