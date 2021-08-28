package com.zh.leetcode.code;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class Q34Dichotomy {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid]==target){
                left = mid+1;
            }
        }
        if (right < 0 || nums[right] != target)
            return new int[]{-1,-1};
        int count = 0;
        for (int i = right-1; i >= 0; i--) {
            if (nums[i] ==target) ++count;
        }
        return new int []{right-count,right};
    }
}
