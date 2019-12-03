package net.mshome.twisted.algorithm.huawei.online.S002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = "";
        while ((inputs = br.readLine()) != null) {
            Stack<String> operatorStack = new Stack<>(); // * （ - ）
            Stack<String> postExpression = new Stack<>(); // 3  72  22
            Map<String, Integer> operators = new HashMap<>(6);
            operators.put("+", 1);
            operators.put("-", 1);
            operators.put("*", 2);
            operators.put("/", 2);
            operators.put("(", 0);

            StringBuilder number = new StringBuilder(0);
            char[] input = inputs.toCharArray();

            // 1. 构造后缀表达式
            for (char c : input) {
                String charStr = String.valueOf(c);
                if ((int) c - (int) '0' < 10 && (int) c - (int) '0' >= 0) {
                    number.append(c);
                } else if (number.length() != 0) {
                    postExpression.push(number.toString());
                    number.setLength(0);
                }

                if (c == ' ') {
                    continue;
                }

                if (c == '(') {
                    operatorStack.push(charStr);
                    continue;
                }
                if (c == ')') {
                    while (!"(".equals(operatorStack.peek())) {
                        postExpression.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                    continue;
                }

                if (operators.get(charStr) != null) {
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(charStr);
                        continue;
                    }
                    while (!operatorStack.isEmpty() &&
                            operators.get(charStr) <= operators.get(operatorStack.peek())) {
                        postExpression.push(operatorStack.pop());
                    }
                    operatorStack.push(charStr);
                }
            }

            if (number.length() != 0) {
                postExpression.push(number.toString());
                number.setLength(0);
            }
            while (!operatorStack.isEmpty()) {
                postExpression.push(operatorStack.pop());
            }
            // 2. 逆序栈元素
            while (!postExpression.isEmpty()) {
                operatorStack.push(postExpression.pop());
            }

            // 3. 计算
            while (operatorStack.size() > 0) {
                String popEle = operatorStack.pop();
                if (operators.get(popEle) == null) { // 数字
                    postExpression.push(popEle);
                } else { // 操作符，进行运算
                    Integer secondValue = Integer.valueOf(postExpression.pop());
                    Integer firstValue = Integer.valueOf(postExpression.pop());
                    postExpression.push(calc(firstValue, secondValue, popEle).toString());
                }
            }
            System.out.println(postExpression.pop());
        }

    }

    private static Integer calc(Integer first, Integer second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }
        return 0;
    }

}
