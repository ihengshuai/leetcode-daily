package com.leetcode.simple;

import org.junit.Test;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 */
public class LengthOfLastWord {
    @Test
    public void test () {
        int len = lengthOfLastWord("asd fgsd asdf sdf gd f ");
        System.out.println(len);
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(n)，其中 nn 是字符串的长度。最多需要反向遍历字符串一次。
     * 空间复杂度：O(1)
     */
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
