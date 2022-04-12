package com.leetcode.simple;

import org.junit.Test;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    @Test
    public void test() {
        int num = mySqrt(8);
        System.out.println(num);
    }

    /**
     * 牛顿迭代法
     * 复杂度分析
     * 时间复杂度O(logx)，此方法是二次收敛的，相较于二分查找更快。
     * 空间复杂度：O(1)。
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
