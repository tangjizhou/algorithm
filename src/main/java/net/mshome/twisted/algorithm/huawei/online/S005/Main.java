package net.mshome.twisted.algorithm.huawei.online.S005;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。
 * 示例1
 * 输入
 *
 * 复制
 * 0xA
 * 输出
 *
 * 复制
 * 10
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {

    public static void main(String[] args) {

        String hex = "0xA";

        hex = hex.substring(2);

        for (char c : hex.toCharArray()) {

        }


    }


    private Integer convertHex(Character value) {
        String str = String.valueOf(value).toUpperCase();
        Map<String, Integer> map = new HashMap<>(5);
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);

        if (map.get(str) == null) {
            return Integer.parseInt(str);
        }
        return map.get(str);

    }


}
