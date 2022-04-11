package com.leetcode.simple;

import org.junit.Test;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    @Test
    public void test() {
        String str = addBinary("1010", "11");
        System.out.println(str);
    }

    /**
     * 通过字符串相加反转
     * 复杂度分析
     * 时间复杂度：O(n)，这里的时间复杂度来源于顺序遍历 a 和 b。
     * 空间复杂度：O(1)，除去答案所占用的空间，这里使用了常数个临时变量。
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
