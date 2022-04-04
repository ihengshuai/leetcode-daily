package com.leetcode.simple;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    @Test
    public void test() {
        String str1 = longestCommonPrefix1(new String[]{"asdffgdhtgd", "asdghsdhg", "asdfg"});
        String str2 = longestCommonPrefix2(new String[]{"asdffgdhtgd", "asdghsdhg", "asdfg"});
        System.out.println(str1);
        System.out.println(str2);
    }

    /**
     * 1.横向扫描
     * 复杂度分析
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefix1(String[] strArr) {
        if (strArr.length == 0) return "";
        String prefix = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            prefix = getLongestTwoCommonPrefix(prefix, strArr[i]);
            if (prefix.length() <= 0) break;
        }
        return prefix;
    }

    /**
     * 2.纵向扫描
     * 复杂度分析
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * 空间复杂度：O(1)。使用的额外空间复杂度为常数。
     */
    public String longestCommonPrefix2(String[] strArr) {
        if (strArr.length == 0) return "";
        for (int i = 0; i < strArr[0].length(); i++) {
            char s = strArr[0].charAt(i);
            for (int j = 1; j < strArr.length; j++) {
                if (strArr[j].charAt(i) != s || i == strArr[j].length()) {
                    return strArr[0].substring(0, i);
                }
            }
        }
        return strArr[0];
    }

    public String getLongestTwoCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < len && str1.charAt(i) == str2.charAt(i)) i++;
        return str1.substring(0, i);
    }
}
