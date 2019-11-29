package net.mshome.twisted.algorithm.huawei.online.S002;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * <p>
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 * <p>
 * 输入描述:
 * 输入算术表达式
 * 输出描述:
 * 计算出结果值
 * 示例1
 * 输入
 * <p>
 * 复制
 * 400+5
 * 输出
 * <p>
 * 复制
 * 405
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/28
 */
public class Main {

    public static void main(String[] args) {
        calc("3 * (72 - 22) + 5 + 3 + 22");
        //[3, 72, 22, -, *, 5, +, 3, +, +]
        //3 50 * 5 + 3 + +
        //    150 5 + 3 + +
        //    155 3 + 2 +
        //    158
    }

    /**
     * 表达式求值,利用后缀表达式，3*(2+1)的后缀表达式为：321+*
     *
     * @return 值
     */
    public static long calc(String inputs) {
        Stack<Character> operatorStack = new Stack<>(); // * （ - ）
        Stack<String> postExpression = new Stack<>(); // 3  72  22
        Map<Character, Integer> operators = new HashMap<>(6);
        operators.put('+', 1);
        operators.put('-', 1);
        operators.put('*', 2);
        operators.put('/', 2);
        operators.put('(', 0);

        StringBuilder number = new StringBuilder(0);
        char[] input = inputs.toCharArray();

        for (char c : input) {
            if ((int) c - (int) '0' < 10 && (int) c - (int) '0' > 0) {
                number.append(c);
            }

            if (c == ' ') {
                if (number.length() != 0) {
                    postExpression.push(number.toString());
                    number.setLength(0);
                }
                continue;
            }

            if (c == '(') {
                if (number.length() != 0) {
                    postExpression.push(number.toString());
                    number.setLength(0);
                }
                operatorStack.push(c);
                continue;
            }
            if (c == ')') {
                if (number.length() != 0) {
                    postExpression.push(number.toString());
                    number.setLength(0);
                }
                while (operatorStack.peek() != '(') {
                    postExpression.push(operatorStack.pop().toString());
                }
                operatorStack.pop();
                continue;
            }

            if (operators.get(c) != null) {
                if (number.length() != 0) {
                    postExpression.push(number.toString());
                    number.setLength(0);
                }
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                    continue;
                }
                while (!operatorStack.isEmpty() && operators.get(c) <= operators.get(operatorStack.peek())) {
                    postExpression.push(operatorStack.pop().toString());
                }
                operatorStack.push(c);
            }

        }
        if (number.length() != 0) {
            postExpression.push(number.toString());
            number.setLength(0);
        }
        while (!operatorStack.isEmpty()) {
            postExpression.push(operatorStack.pop().toString());
        }

        System.out.println(operatorStack);
        System.out.println(postExpression);
        return 1;
    }


}
