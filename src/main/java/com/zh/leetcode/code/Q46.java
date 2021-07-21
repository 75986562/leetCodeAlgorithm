package com.zh.leetcode.code;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Q46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        System.out.println(JSONObject.toJSONString(list));
    }

    static List<List<Integer>> res = new LinkedList<>();
    static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        res = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 所有数都填完了
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            // 做出选择
            track.add(nums[i]);
            // 继续递归填下一个数
            backtrack(nums,track);
            // 撤销选择操作，准备做其他的选择
            track.removeLast();
        }

    }
}
