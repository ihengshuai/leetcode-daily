package com.leetcode.simple;

import com.util.ListNode;
import org.junit.Test;

/**
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class DeleteDuplicates {
    @Test
    public void test() {
        ListNode node = deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1))));
        System.out.println(node);
    }

    /**
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
