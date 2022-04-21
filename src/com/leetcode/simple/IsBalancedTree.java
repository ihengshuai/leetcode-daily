package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 */

// 什么是平衡二叉树 https://zhuanlan.zhihu.com/p/56066942
// 平衡二叉树：左右子树的高度相差不超过 1 的树为平衡二叉树
// 平衡因子：某节点的左子树与右子树的高度(深度)差即为该节点的平衡因子（BF,Balance Factor），
// 平衡二叉树中不存在平衡因子大于 1 的节点。在一棵平衡二叉树中，节点的平衡因子只能取 0 、1 或者 -1 ，
// 分别对应着左右子树等高，左子树比较高，右子树比较高。
public class IsBalancedTree {
    @Test
    public void test() {
        boolean flag1 = isBalanced1(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        boolean flag2 = isBalanced2(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        System.out.println(flag1);
        System.out.println(flag2);
    }

    /**
     * 自下向顶遍历
     * 复杂度分析
     * 时间复杂度 O(N)： N 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
     * <p>
     * 算法分析:
     * 递归返回值：
     * 当节点root 左 / 右子树的高度差 <2 ：则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加 1 （ max(left, right) + 1 ）；
     * 当节点root 左 / 右子树的高度差 ≥2 ：则返回 −1 ，代表 此子树不是平衡树 。
     * 递归终止条件：
     * 当越过叶子节点时，返回高度 0 ；
     * 当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回 −1 ；
     */
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    protected int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 自顶向下递归遍历
     * 复杂度分析：
     * 时间复杂度：O(n^2)，其中 n 是二叉树中的节点个数。
     * 最坏情况下，二叉树是满二叉树，需要遍历二叉树中的所有节点，时间复杂度是 O(n)。
     * 对于节点 p，如果它的高度是 d，则 height(p) 最多会被调用 d 次（即遍历到它的每一个祖先节点时）。
     * 对于平均的情况，一棵树的高度 h 满足 O(h)=O(logn)，因为 hd≤h，所以总时间复杂度为 O(nlogn)。
     * 对于最坏的情况，二叉树形成链式结构，高度为 O(n)，此时总时间复杂度为 O(n^2)。
     * 空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return isBalanced2(root.left) && isBalanced2(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    protected int depth(TreeNode tree) {
        if (tree == null) return 0;
        return Math.max(depth(tree.left), depth(tree.right)) + 1;
    }
}
