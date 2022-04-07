package com.leetcode.simple;

import org.junit.Test;

/**
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class StrStr {
    @Test
    public void test() {
        int idx1 = strStr1("mississippi", "issip");
        int idx2 = strStr2("mississippi", "issip");
        int idx3 = strStr3("mississippi", "issip");
        System.out.println(idx1);
        System.out.println(idx2);
        System.out.println(idx3);
    }

    /**
     * 双指针
     * 复杂度
     * 时间复杂度：log(n)，其中 n 是数组的长度。
     * 空间复杂度：O(1)。只需要使用常数的额外空间。
     */
    public int strStr1(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) return 0;
        int low = 0, high = 0;
        boolean flag = false;
        while (low <= high && high < haystack.length()) {
            if (!flag) {
                if (haystack.charAt(high) == needle.charAt(0)) {
                    low = high;
                    flag = true;
                }
            } else {
                if (haystack.charAt(high) != needle.charAt(high - low)) {
                    flag = false;
                    high = low;
                }
            }
            high++;
            if (flag && high - low == needle.length()) return low;
        }
        return -1;
    }

    /**
     * 暴力破解
     * 复杂度分析
     * 时间复杂度：O(n×m)，其中 nn 是字符串 haystack 的长度，mm 是字符串 needle 的长度。最坏情况下我们需要将字符串 needle 与字符串 haystack 的所有长度为 mm 的子串均匹配一次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     */
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法
     * 复杂度分析
     * 时间复杂度：n 为原串的长度，m 为匹配串的长度。复杂度为 O(m+n)。
     * 空间复杂度：构建了 next 数组。复杂度为 O(m)。
     */
    public int strStr3(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }
}
