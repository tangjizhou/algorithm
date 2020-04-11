package net.mshome.twisted.algorithm.huawei.online;

import java.util.Scanner;

/**
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/28
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            input = input.trim();
            int index = input.length();
            int length = 0;
            while (--index >= 0 && ' ' != input.charAt(index)) {
                ++length;
            }
            System.out.println(length);
        }
    }

}
