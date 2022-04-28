package com.leetcode.simple;

import org.junit.Test;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class AppearOnceNumber {
    @Test
    public void test() {
        int i = singleNumber(new int[]{1, 1, 2, 2, 3});
        System.out.println(i);
    }


    /**
     * 位运算
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是数组长度。只需要对数组遍历一次。
     * 空间复杂度：O(1)。
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
