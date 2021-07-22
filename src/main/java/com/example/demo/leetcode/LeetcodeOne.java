package com.example.demo.leetcode;


import com.example.demo.common.TreeNode;
import com.example.demo.common.TreeUtil;

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
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution19 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode index = head;
            int count = 0;
            while (index != null) {
                count++;
                index = index.next;
            }
            if (count < n) {
                return head;
            }
            ListNode yummy = new ListNode(0, head);
            int i = count - n + 1;
            ListNode pre = yummy;
            for (int j = 1; j < i; ++j) {
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

    /**
     * 三数之和
     */
    static class Solution15 {
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            if (length < 3) {
                return res;
            }
            for (int i = 0; i < length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int right = length - 1;
                for (int j = i + 1; j < length - 1; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    while (nums[right] > target - nums[j] && j < right) {
                        right--;
                    }
                    if (j == right) {
                        break;
                    }
                    if (nums[j] + nums[right] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[right]);
                        res.add(item);
                    }
                }
            }
            return res;
        }
    }

    /**
     * 有效括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     */
    class Solution20 {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            if (chars.length % 2 == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>(4);
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
            Deque<Character> deque = new LinkedList<>();

            for (char item : chars) {
                if (map.containsKey(item)) {
                    deque.push(item);
                } else {
                    if (deque.isEmpty() || item != map.get(deque.pop())) {
                        return false;
                    }
                }
            }
            if (deque.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }


    }

    /**
     * 二叉树的中序遍历  递归
     * 前序遍历：打印 - 左 - 右
     * 中序遍历：左 - 打印 - 右
     * 后序遍历：左 - 右 - 打印
     */
    static class Solution94 {
        public static List<Integer> inorderTraversal(TreeNode root) {
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

        public static void main(String[] args) {

            Integer[] arr = {1, null, 2, 3};
            TreeNode tree = TreeUtil.createTree(arr);
            System.out.println(inorderTraversal(tree));

        }
    }

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     */
    static class Solution239 {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
            if (n <= k) {
                for (int i = 0; i < n; i++) {
                    maxHeap.add(new int[]{nums[i], i});
                }
                if (maxHeap.peek() != null) {
                    return new int[]{maxHeap.peek()[0]};
                }
            }
            int[] res = new int[n - k + 1];
            for (int i = 0; i < n; i++) {
                if (i < k - 1) {
                    maxHeap.add(new int[]{nums[i], i});
                } else {
                    maxHeap.add(new int[]{nums[i], i});

                    while (maxHeap.peek()[1] < i - k + 1) {
                        maxHeap.poll();
                    }
                    res[i - k + 1] = maxHeap.peek()[0];
                }
            }
            return res;
        }
    }

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 回溯算法 控制 条件的开始 结束 以及递归部分
     */
    static class Solution141 {
        public static List<List<Integer>> permute(int[] nums) {
            int length = nums.length;
            if (length < 1) {
                return new ArrayList<>();
            }
            int depth = 0;
            Deque<Integer> path = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[length];
            recursionSection(nums, depth, length, path, res, used);
            return res;
        }

        public static void recursionSection(int[] nums, int depth, int length, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
            if (depth == length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    path.push(nums[i]);
                    used[i] = true;
                    recursionSection(nums, depth + 1, length, path, res, used);
                    path.pop();
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(Solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        List<List<Integer>> res = Solution141.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     * 实现 LRUCache 类：
     * <p>
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    class LRUCache extends LinkedHashMap {

        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return (int) super.getOrDefault(key, -1);

        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }


}


