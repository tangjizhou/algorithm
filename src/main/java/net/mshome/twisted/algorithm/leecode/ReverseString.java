package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 反转字符串
 *
 * @author tangjizhou
 * @since 2021/7/15
 */
public class ReverseString {

    @Test
    public void test() {
        char[] s = {};
        reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            ++l;
            --r;
        }

    }

}
