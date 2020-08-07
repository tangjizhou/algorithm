package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效括号
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/8/6
 */
public class ValidParentheses {

    @Test
    public void test() {
        Assert.assertTrue(isValid("("));
    }

    private static final Map<Character, Character> map = new HashMap<>(3);

    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();
        if (map.get(chars[0]) == null || (chars.length & 1) != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.isEmpty() || map.get(stack.peek()) != aChar) {
                if (map.get(aChar) == null) {
                    return false;
                }
                stack.push(aChar);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
