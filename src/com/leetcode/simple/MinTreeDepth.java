package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class MinTreeDepth {
    @Test
    public void test() {
        int depth = minTreeDepth(new TreeNode(0, new TreeNode(1), new TreeNode(2, new TreeNode(3), null)));
        System.out.println(depth);
    }

    /**
     * 递归遍历
     * 复杂度分析
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，
     * 最坏情况下，树呈现链状，空间复杂度为 O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
     */
    public int minTreeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minTreeDepth(root.right) + 1;
        if (root.right == null) return minTreeDepth(root.left) + 1;
        return Math.min(minTreeDepth(root.left), minTreeDepth(root.right)) + 1;
    }
}
