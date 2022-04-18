package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

/**
 * #101
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class IsSymmetricTree {
    @Test
    public void test() {
        boolean bool1 = isSymmetric(new TreeNode(1, new TreeNode(2), new TreeNode(2)));
        boolean bool2 = isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null)));
        System.out.println(bool1);
        System.out.println(bool2);
    }

    /**
     * 递归遍历
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：o(n)
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return dfs(root.left, root.right);
    }

    protected boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
