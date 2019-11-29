package net.mshome.twisted.algorithm.huawei.online.S001;

import java.io.IOException;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/28
 */
public class Main {


    public static int calcLastWordLength(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.trim();
        int index = input.length();
        int length = 0;
        while (--index >= 1 && ' ' != input.charAt(index)) {
            ++length;
        }
        return length;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calcLastWordLength("adsf dafdfa"));
    }

}
