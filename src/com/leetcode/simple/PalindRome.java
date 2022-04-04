package com.leetcode.simple;

import org.junit.Test;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindRome {
    @Test
    public void test() {
        boolean t1 = isPalindrome(12321);
        boolean t2 = isPalindromeForReverse(12321);
        boolean t3 = isPalindrome(0);
        boolean t4 = isPalindromeForReverse(0);
        boolean t5 = isPalindrome(-1);
        boolean t6 = isPalindromeForReverse(-1);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
    }

    /**
     * 1.双指针
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        String strNum = new Integer(x).toString();
        for (int i = 0, j = strNum.length() - 1; i <= j; i++, j--) {
            if (strNum.charAt(i) != strNum.charAt(j)) return false;
        }
        return true;
    }

    /**
     * 2.数字反转
     * 复杂度分析
     * 时间复杂度：O(logn)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为 O(logn)。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     */
    public boolean isPalindromeForReverse(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + reverseNumber % 10;
            x = (int) Math.floor(reverseNumber);
        }
        return reverseNumber == x || x == Math.floor(reverseNumber / 10);
    }
}
