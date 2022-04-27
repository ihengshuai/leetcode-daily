package com.leetcode.simple;

import org.junit.Test;

import java.util.Locale;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class IsPalindrome {
    @Test
    public void test() {
        boolean str = isPalindrome(",");
        System.out.println(str);
    }

    /**
     * 双指针遍历
     * 复杂度分析
     * 时间复杂度：O(∣s∣)，其中 ∣s∣ 是字符串 s 的长度。
     * 空间复杂度：O(1)。
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int leftIdx = 0;
        int rightIdx = s.length() - 1;
        while (leftIdx <= rightIdx) {
            char lch = s.charAt(leftIdx);
            char rch = s.charAt(rightIdx);
            if (Character.isLetterOrDigit(lch) && Character.isLetterOrDigit(rch)) {
                if (lch != rch) return false;
                leftIdx++;
                rightIdx--;
            } else if (Character.isLetterOrDigit(lch)) rightIdx--;
            else leftIdx++;
        }
        return true;
    }
}
