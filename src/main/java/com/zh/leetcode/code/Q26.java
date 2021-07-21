package com.zh.leetcode.code;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Q26 {


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 3, 3, 4, 5, 5, 7, 999, 1111};
        System.out.println(removeDuplicates(nums1));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 0;int j = 1;
        while (j < nums.length) {
            if (nums[j] > nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
