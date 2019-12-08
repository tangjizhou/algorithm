package net.mshome.twisted.algorithm.huawei.online.S0010;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述:
 * 输入一个整数（int类型）
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 * 示例1
 * 输入
 * <p>
 * 复制
 * 5
 * 输出
 * <p>
 * 复制
 * 2
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            int count = 0;

            // 1. 按位与，n & (n-1) 可以去除最低位的1
            while (input != 0) {
                input &= input - 1;
                count++;
            }

            // 2. 老老实实求最大的数
            // while (input > 0) {
            //     int maxBinary = getClosestBinary(input);
            //     input -= maxBinary;
            //     if (maxBinary > 0) {
            //         count++;
            //     }
            // }
            System.out.println(count);

        }
    }


    private static int getClosestBinary(int number) {
        if (number < 2) {
            return number;
        }
        int binary = 2;
        while (binary <= number) {
            binary <<= 1;
        }
        return binary >> 1;
    }

}
