package com.ihengshuai.core.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1 两数之和
 */

public class TwoNumberSum {
    @Test
    public void test() {
        int[] ints = twoNumberSum(new int[]{1, 6, 2}, 8);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = twoNumberSum(new int[]{10, 6, 99, 1, 6, 2}, 100);
        System.out.println(Arrays.toString(ints2));
    }

    public int[] twoNumberSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }

            hashMap.put(nums[i], i);
        }

        return new int[0];
    }
}
