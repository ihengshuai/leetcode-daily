package com.leetcode.simple;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs {
    @Test
    public void test() {
        int step1 = climbStairs(5);
        int step2 = climbStairs(5);
        System.out.println(step1);
        System.out.println(step2);
    }

    /**
     * 动态规划
     * 复杂度分析
     * 时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
     * 空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)。
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 递归
     * 复杂度分析
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     */
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}
