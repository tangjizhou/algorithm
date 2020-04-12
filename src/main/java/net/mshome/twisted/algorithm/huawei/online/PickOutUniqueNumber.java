package net.mshome.twisted.algorithm.huawei.online;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入描述:
 * 输入一个int型整数
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例1
 * 输入
 * <p>
 * 复制
 * 9876673
 * 输出
 * <p>
 * 复制
 * 37689
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/12
 */
public class PickOutUniqueNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            Integer[] resultArr = new Integer[10];
            StringBuilder result = new StringBuilder();

            for (int i = input.length() - 1; i >= 0; --i) {
                int value = input.charAt(i) - '0';
                if (resultArr[value] == null) {
                    result.append(value);
                }
                resultArr[value] = value;
            }
            System.out.println(Integer.parseInt(result.toString()));
        }
    }

}
