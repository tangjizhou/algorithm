package net.mshome.twisted.algorithm.huawei.online.S006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * <p>
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * 输入参数：
 * long ulDataInput：输入的正整数
 * 返回值：
 * String
 * <p>
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * 示例1
 * 输入
 * <p>
 * 复制
 * 180
 * 输出
 * <p>
 * 复制
 * 2 2 3 3 5
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            List<String> factors = new ArrayList<>();
            int factor = 2;
            int loopIndex = 1;
            while (factor != number) {

                // 一直除以2，直到为奇数
                if (number % factor == 0) {
                    factors.add(String.valueOf(factor));
                    number = number / factor;
                    continue;
                }

                // 此时，number已经为奇数,奇数的因子必为奇数
                factor = loopIndex++ * 2 + 1;
            }
            factors.add(String.valueOf(factor));
            System.out.println(String.join(" ", factors) + " ");

        }
    }

}
