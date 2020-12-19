package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 思路：动态规划
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/11
 */
public class LongestPalindrome {

    @Test
    public void main() {
        Assert.assertEquals("cbbc", longestPalindrome("acbbcd"));
        Assert.assertEquals("acbbca", dpLongestPalindrome("acbbca"));
        Assert.assertEquals("cbbc", dpLongestPalindrome("acbbcd"));
        Assert.assertEquals("a", dpLongestPalindrome("ac"));
    }

    // 动态规划
    public String dpLongestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[chars.length][chars.length];
        // dp[i][j] = dp[i+1][j-1] && s[i] = s[j]
        int max = 0, start = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }


    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 0, start = 0;
        for (int i = 0; i < chars.length; i++) {
            int oddLength = expandAroundCenter(chars, i, i);
            int evenLength = expandAroundCenter(chars, i, i + 1);
            int length = Math.max(oddLength, evenLength);
            if (length > max) {
                max = length;
                start = i - (max - 1) / 2;
            }
        }
        return s.substring(start, max + start);
    }


    private int expandAroundCenter(char[] chars, int start, int end) {
        int maxLength = 0;
        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            int length = end - start + 1;
            maxLength = Math.max(length, maxLength);
            --start;
            ++end;
        }
        return maxLength;
    }


}
