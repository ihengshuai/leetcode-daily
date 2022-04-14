package com.util;

/*
 * @description: TODO
 * @author: peachick
 * @createTime: 2022/4/15 07:18
 * Copyright (c) 2016-2022 Peachick<Peachick@aliyun.com>. All rights reserved.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
