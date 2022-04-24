package com.leetcode.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角，给定指定行数，生成杨辉三角
 */
public class YangHuiTriangle {
    @Test
    public void test() {
        List<List<Integer>> list = generate(3);
        System.out.println(list);
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(numRows2)。
     * 空间复杂度：O(1)。不考虑返回值的空间占用。
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(row);
        }
        return lists;
    }
}
