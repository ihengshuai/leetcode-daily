package com.leetcode.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 */
public class YangHuiTriangle2 {
    @Test
    public void test() {
        List<Integer> row = getRow(4);
        System.out.println(row);
    }

    /**
     * 线性递归
     * 复杂度分析
     * 时间复杂度：O(rowIndex)
     * 空间复杂度：O(1)。
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
