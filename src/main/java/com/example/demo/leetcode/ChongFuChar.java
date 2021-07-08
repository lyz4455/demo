package com.example.demo.leetcode;

/**
 * 一个字符串 找到他第一次重复出现的位置 要求用二分查找
 */
public class ChongFuChar {
    public static int chongFuFirst(String strings, char target) {
        int n = strings.length();
        for (int i = 0; i < n; i++) {
            int res = erFen(strings.substring(0, i).toCharArray(), target);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param chars  字符串的字符数组
     * @param target 目标值
     * @return
     */
    public static int erFen(char[] chars, char target) {
        int n = chars.length - 1;
        int left = 0;
        int right = n;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (chars[mid] < target) {
                left = mid + 1;
            } else if (chars[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ChongFuChar.chongFuFirst("aaabbb", 'b'));
    }

}
