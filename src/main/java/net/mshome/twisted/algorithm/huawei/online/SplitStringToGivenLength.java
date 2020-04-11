package net.mshome.twisted.algorithm.huawei.online;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * 示例1
 * 输入
 * <p>
 * 复制
 * abc
 * 123456789
 * 输出
 * <p>
 * 复制
 * abc00000
 * 12345678
 * 90000000
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/4
 */
public class SplitStringToGivenLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            line = line.length() % 8 == 0 ? line : line + "00000000";

            while (line.length() >= 8) {
                System.out.println(line.substring(0, 8));
                line = line.substring(8);
            }
        }

    }


}

