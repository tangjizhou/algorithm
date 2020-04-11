package net.mshome.twisted.algorithm.huawei.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。
 * 示例1
 * 输入
 * <p>
 * 复制
 * 0xA
 * 输出
 * <p>
 * 复制
 * 10
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class ConvertHexToDecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String validNumbers = input.substring(2);
            long result = 0;
            for (char c : validNumbers.toCharArray()) {
                result = result * 16 + convertHex(c);
            }
            System.out.println(result);
        }


    }


    private static Integer convertHex(Character value) {
        Map<Character, Integer> map = new HashMap<>(5);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        if (map.get(value) == null) {
            return value - '0';
        }
        return map.get(value);

    }


}
