package com.zh.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指字母相同，但排列不同的字符串。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class Q438 {
    public static void main(String[] args) {
        String[] strs = {"cbaebabacd", "abc", "abab", "ab","sssasf","sa"};
        for (int i = 0; i < 6; i = i + 2) {
            System.out.println(findAnagrams(strs[i], strs[i + 1]));
        }

    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap();
        HashMap<Character, Integer> window = new HashMap();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        return res;
    }
}
