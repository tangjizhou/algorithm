package net.mshome.twisted.algorithm.huawei.online.S007;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:
 * 输入一个正浮点数值
 * 输出描述:
 * 输出该数值的近似整数值
 * 示例1
 * 输入
 * <p>
 * 复制
 * 5.5
 * 输出
 * <p>
 * 复制
 * 6
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            double number = scanner.nextDouble();
            String numberStr = String.valueOf(number);
            // 不是小数，直接输出就行
            if (!numberStr.contains(".")) {
                System.out.println(number);
                continue;
            }
            // 如果是小数，需要考虑是否为最大double，溢出的问题，采用string处理
            String[] str = numberStr.split("\\.");
            String decimal = str[1].substring(0, 1);
            int singles = Integer.parseInt(decimal) >= 5 ? 1 : 0;
            char[] chars = str[0].toCharArray();
            for (int i = chars.length - 1; i >= 0; --i) {
                int value = chars[i] - '0';
                value = value + singles;
                if (value >= 10) {
                    chars[i] = (char) (value % 10 + '0');
                } else {
                    chars[i] = (char) (value + '0');
                    break;
                }
            }
            System.out.println(chars);
        }
    }

}
