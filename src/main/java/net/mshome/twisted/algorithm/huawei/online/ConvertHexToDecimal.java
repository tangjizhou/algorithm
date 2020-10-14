package net.mshome.twisted.algorithm.huawei.online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

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
            String result = "0";
            for (char c : validNumbers.toCharArray()) {
                String decimal = convertHex(c).toString();
                if (!"0".equals(result)) {
                    for (int i = 0; i < 4; i++) {
                        result = add(result, result);
                    }
                }
                result = add(result, decimal);
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

    private static String add(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        char[] num1Arr = new char[length];
        char[] num2Arr = new char[length];
        System.arraycopy(num1.toCharArray(), 0, num1Arr, length - num1.length(), num1.length());
        System.arraycopy(num2.toCharArray(), 0, num2Arr, length - num2.length(), num2.length());
        int forward = 0;
        for (int i = length - 1; i >= 0; --i) {
            int a = Math.max((num1Arr[i] - '0'), 0);
            int b = Math.max((num2Arr[i] - '0'), 0);
            int c = a + b + forward;
            forward = c >= 10 ? 1 : 0;
            c %= 10;
            num1Arr[i] = (char) (c + '0');
        }
        return forward == 1 ? "1".concat(new String(num1Arr)) : new String(num1Arr);
    }


    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     while (sc.hasNext()) {
    //         String input = sc.nextLine();
    //         String validNumbers = input.substring(2);
    //         long result = 0;
    //         for (char c : validNumbers.toCharArray()) {
    //             result = result * 16 + convertHex(c);
    //         }
    //         System.out.println(result);
    //     }
    //
    //
    // }
    //
    //
    // private static Integer convertHex(Character value) {
    //     Map<Character, Integer> map = new HashMap<>(5);
    //     map.put('A', 10);
    //     map.put('B', 11);
    //     map.put('C', 12);
    //     map.put('D', 13);
    //     map.put('E', 14);
    //     map.put('F', 15);
    //
    //     if (map.get(value) == null) {
    //         return value - '0';
    //     }
    //     return map.get(value);
    //
    // }

}
