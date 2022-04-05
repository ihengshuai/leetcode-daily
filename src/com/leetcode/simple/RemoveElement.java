package com.leetcode.simple;

import org.junit.Test;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    @Test
    public void test() {
        int ele1 = removeElement1(new int[]{1, 1, 2, 4, 6}, 1);
        int ele2 = removeElement1(new int[]{1, 1, 2, 4, 6}, 1);
        int ele3 = removeElement1(new int[]{1, 1, 2, 4, 6}, 1);
        System.out.println(ele1);
        System.out.println(ele2);
        System.out.println(ele3);
    }

    /**
     * 双指针
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为序列的长度。我们只需要遍历该序列至多两次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     */
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 双指针优化
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为序列的长度。我们只需要遍历该序列至多一次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 遍历数组，将不是目标值的元素赋值到指定位置
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为序列的长度。我们只需要遍历该序列至多两次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     */
    public int removeElement3(int[] nums, int val) {
        int idx = 0;
        for (int elem : nums) {
            if (elem != val) nums[idx++] = elem;
        }
        return idx;
    }
}
