package com.leetcode.simple;

import org.junit.Test;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    @Test
    public void test() {
        int max1 = maxProfit1(new int[]{4, 3, 5, 10, 9, 7});
        int max2 = maxProfit2(new int[]{4, 3, 5, 10, 9, 7});
        System.out.println(max1);
        System.out.println(max2);
    }

    /**
     * 暴力破解
     * 复杂度分析
     * 时间复杂度：O(n^2)循环运行n(n−1)/2次
     * 空间复杂度：O(1)只使用了常数个变量
     */
    public int maxProfit1(int[] prices) {
        if (prices == null) return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 一次遍历
     * 复杂度分析
     * 时间复杂度：O(n)，只需要遍历一次。
     * 空间复杂度：O(1)，只使用了常数个变量。
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
