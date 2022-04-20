package com.leetcode.simple;

import com.util.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxTreeDepth {
    @Test
    public void test() {
        TreeNode tree1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        int depth1 = maxDepthByDFS(tree1);
        int depth2 = maxDepthByBFS(tree1);
        System.out.println(depth1);
        System.out.println(depth2);
    }

    /**
     * 深度优先遍历 dfs
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，
     * 而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     */
    public int maxDepthByDFS(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepthByDFS(root.left);
        int rightDepth = maxDepthByDFS(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 广度优先遍历
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
     * 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
     */
    public int maxDepthByBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}
