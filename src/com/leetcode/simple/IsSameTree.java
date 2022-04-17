package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 */
public class IsSameTree {
    @Test
    public void test() {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode tree2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode tree3 = new TreeNode(2, new TreeNode(1), null);
        boolean f1 = isSameTree(tree1, tree2);
        boolean f2 = isSameTree(tree1, tree3);
        System.out.println(f1);
        System.out.println(f2);
    }

    /**
     * 深度优先算法（判断遍历终止的条件）
     * 复杂度分析
     * 时间复杂度：O(min(m,n))，其中m,n分别是两个二叉树的节点数，对两个二叉树同时进行深度优先搜索，
     * 只有当两个二叉树中的对应节点的都不为空时才会访问到该节点，因此访问到该节点书数不会超过较小的二叉树的节点数
     * 空间复杂度：O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复杂度取决于递归调用的层数，
     * 递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, p.left) && isSameTree(p.right, q.right);
    }
}
