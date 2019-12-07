package net.mshome.twisted.algorithm.huawei.online.S009;

import java.util.*;

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
 * @date 2019/12/6
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            String numberStr = String.valueOf(number);
            int result = 0;
            Set<Character> characterSet = new HashSet<>();
            char[] chars = numberStr.toCharArray();
            for (int i = chars.length - 1; i >= 0; --i) {
                if (!characterSet.add(chars[i])) {
                    continue;
                }
                result *= 10;
                result += (chars[i] - '0');
            }
            System.out.println(result);

        }
    }

}
