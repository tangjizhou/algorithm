package net.mshome.twisted.algorithm.huawei.online.S0013;

import java.util.*;

/**
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入
 * <p>
 * 复制
 * abcdd
 * 输出
 * <p>
 * 复制
 * dd
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2020/1/8
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int[] alphabet = new int[26];
            char[] chars = input.toCharArray();
            int min = 20;
            for (char c : chars) {
                int alphabetIndex = c - 'a';
                alphabet[alphabetIndex]++;
                min = Math.min(min, alphabet[alphabetIndex]);
            }

            StringBuilder result = new StringBuilder(0);
            for (char aChar : chars) {
                if (alphabet[aChar - 'a'] != min) {
                    result.append(aChar);
                }
            }
            System.out.println(result);
        }
    }


}
