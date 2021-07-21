package com.zh.leetcode.code;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 */
public class Q53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int dp0 = nums[0];
        int dp1 = 0, res = dp0;
        for (int i = 1; i < nums.length; i++) {
            dp1 = Math.max(nums[i], nums[i] + dp0);
            dp0 = dp1;
            res = Math.max(dp1,res);
        }
        return res;
    }


}
