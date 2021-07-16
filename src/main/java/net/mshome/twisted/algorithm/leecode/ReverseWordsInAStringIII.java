package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 反转字符串中的单词 III
 *
 * @author tangjizhou
 * @since 2021/7/16
 */
public class ReverseWordsInAStringIII {

    @Test
    public void test() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        while (r < chars.length) {
            if (r == chars.length - 1) {
                reverse(chars, l, r);
                ++r;
                continue;
            }

            if (chars[r] == ' ') {
                reverse(chars, l, r - 1);
                l = r + 1;
            }
            ++r;
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            ++l;
            --r;
        }
    }

}
