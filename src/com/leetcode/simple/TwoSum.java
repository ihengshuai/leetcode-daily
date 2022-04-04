package com.leetcode.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class TwoSum {
    @Test
    public void test() {
        int[] sum1 = twoSum1(new int[]{2, 10, 4, 9, 6}, 10);
        int[] sum2 = twoSum1(new int[]{2, 10, 4, 9, 6}, 0);
        int[] sum3 = twoSum2(new int[]{2, 10, 4, 9, 6}, 10);
        int[] sum4 = twoSum2(new int[]{2, 10, 4, 9, 6}, 0);
        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));
        System.out.println(Arrays.toString(sum3));
        System.out.println(Arrays.toString(sum4));
    }

    /**
     * 1.暴力破解
     * 复杂度分析:
     * 时间复杂度：O(N^2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)。
     */
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 2.hashTable
     * 复杂度分析:
     * 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * 空间复杂度：O(1)。
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> hashTable = new HashMap();
        for (int i = 0; i < len; ++i) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
