package com.zh.leetcode.code;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Q51 {
    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(solveNQueens(4)));
    }

    //创建结果集res
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        //生成棋盘，每一个StringBuilder视为row某一行的排列。
        ArrayList<StringBuilder> track = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            track.add(sb);
        }
        backtrace(track, 0);
        return res;
    }

    static void backtrace(ArrayList<StringBuilder> track, int row) {
        // 结束条件：如果每一行都成功放置了皇后，记录结果
        if (track.size() == row) {
            ArrayList<String> track1 = new ArrayList<>();
            //讲StringBuilder类转化为String类
            for (int i = 0; i < track.size(); i++) {
                track1.add(track.get(i).toString());
            }
            res.add(track1);
            return;
        }

        int n = track.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(track, row, col)) continue;
            track.get(row).setCharAt(col, 'Q');
            backtrace(track, row + 1);
            track.get(row).setCharAt(col, '.');
        }

    }

    // 是否可以在目标位置放皇后
    static boolean isValid(ArrayList<StringBuilder> track, int row, int col) {
        int n = track.size();
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (track.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (track.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (track.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
