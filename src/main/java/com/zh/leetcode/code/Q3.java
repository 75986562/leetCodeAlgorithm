package com.zh.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class Q3 {
    public static void main(String[] args) {
        String[] strs = {"abcabcbb", "bbbbb", "pwwkew", "", "sssasf", "sa"};
        for (int i = 0; i < 6; i++) {
            System.out.println(lengthOfLongestSubstring(strs[i]));
        }

    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap();
        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
//            System.out.println("w1 right=" + right + " left=" + left + " c=" + c + " cCount=" + window.get(c) + " res=" + res);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
//                System.out.println("n1 right=" + right + " left=" + left + " d=" + d + " cCount=" + window.get(d) + " res=" + res);
            }
            res = Math.max(res, right - left);
        }
        return res;
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
                window.put(c, window.getOrDefault(c, 0) + 1);
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
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
