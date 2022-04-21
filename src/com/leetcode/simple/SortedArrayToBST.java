package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class SortedArrayToBST {
    @Test
    public void test() {
        TreeNode tree = sortedArrayToBST(new int[]{1, 2, 3, 9, 10});
        System.out.println(tree);
    }

    /**
     * 深度优先遍历
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是数组的长度。每个数字只访问一次。
     * 空间复杂度：O(logn)，其中 n 是数组的长度。空间复杂度不考虑返回值，
     * 因此空间复杂度主要取决于递归栈的深度，递归栈的深度是O(logn)。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    protected TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }
}
