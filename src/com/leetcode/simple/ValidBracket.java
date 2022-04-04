package com.leetcode.simple;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 */
public class ValidBracket {
    @Test
    public void test() {
        boolean isvalid1 = SolutionBracket.isValidBracket("{[(){[]}]}");
        boolean isvalid2 = SolutionBracket.isValidBracket("{}]}");
        System.out.println(isvalid1);
        System.out.println(isvalid2);
    }
}

class SolutionBracket {
    protected static int getValue(char ch) {
        switch (ch) {
            case '(':
                return -1;
            case ')':
                return 1;
            case '{':
                return -2;
            case '}':
                return 2;
            case '[':
                return -3;
            case ']':
                return 3;
            default:
                return 0;
        }
    }

    public static boolean isValidBracket(String str) {
        if (str.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        int i = 0;
        while (i < str.length()) {
            if (getValue(str.charAt(i)) < 0) {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (getValue(str.charAt(i)) + getValue(last) != 0) return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}