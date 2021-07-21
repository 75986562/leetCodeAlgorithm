package com.zh.leetcode.code;

/**
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,3,3,4,3,2,4,2};
        int n = 7;

        System.out.println(containsDuplicate(nums1));
    }

    public static boolean containsDuplicate(int[] nums) {
        int[] nums1 = new int[10];

        for (int n : nums) {
            nums1[n] ++;
        }
        for (int i =0;i<nums1.length;i++){
            if(nums1[i]>1){
                return true;
            }

        }
        return false;
    }


}


