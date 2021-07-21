package com.zh.leetcode.code;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的
 */
public class Q322 {
    public static void main(String[] args) {
        int[] nums1 = {20,25,15};
        System.out.println(coinChange(nums1, 75));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        //最大硬币数不会超过amount，因此选用amount + 1作为最大值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        int ret = (dp[amount] == (amount + 1)) ? -1 : dp[amount];
        return ret;
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] count = new int[amount + 1];
        return doCoinChange(coins, amount, count);
    }

    public static int doCoinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = doCoinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
