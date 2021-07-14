package com.example.demo.learnlab.sort;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-07-09 15:14
 */
public class QuickSort {
    private static void qkSort(int[] nums, int start, int end) {
        if (nums.length < 1) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int cur = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= cur) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= cur) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = cur;
        qkSort(nums, start, left - 1);
        qkSort(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44};
        QuickSort.qkSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
