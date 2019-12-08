package net.mshome.twisted.algorithm.interview;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * 此面试题为：
 * 给定一个由数字构成的字符串数组如，{"102","123","134","143","023"}（每个字符串第长度可无限长，不一定是三位）
 * 将数组中第每个元素构成 "最小数字"，然后以数字排序规则进行从小到大排序。
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/15
 */

public class StringConvertAndSort {

    @Test
    public void test() {
        String[] values = {"102", "123", "134", "423", "023"};
        convertAndSort(values);
    }
    // 顺着思路，暴力解决吧先
    public void convertAndSort(final String[] values) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        String everyChar = "";
        for (String value : values) {
            int index = 0;
            while (index < value.length()) {
                everyChar = String.valueOf(value.charAt(index));
                treeMap.put(everyChar, everyChar);
                ++index;
            }
            value = String.join("", treeMap.values());
            treeMap.clear();
            if (value.charAt(0) == '0') {
                char[] chars = value.toCharArray();
                char char0 = chars[0];
                char char1 = chars[1];
                chars[1] = char0;
                chars[0] = char1;
                value = String.valueOf(chars);
            }
            System.out.println(value);
        }

    }

}
