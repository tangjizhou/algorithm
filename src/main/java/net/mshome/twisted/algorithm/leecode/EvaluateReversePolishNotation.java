package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 后缀表达式求值
 *
 * @author tangjizhou
 * @since 2021/5/15
 */
public class EvaluateReversePolishNotation {

    @Test
    public void test() {
        Assert.assertEquals(2, evalRPN(new String[]{"1", "1", "+"}));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                stack.push(evaluate(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return List.of("+", "-", "*", "/").contains(token);
    }

    private Integer evaluate(String operator, Integer op2, Integer op1) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> 0;
        };
    }

}
