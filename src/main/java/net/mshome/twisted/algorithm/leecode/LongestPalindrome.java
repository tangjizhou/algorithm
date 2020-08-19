package net.mshome.twisted.algorithm.leecode;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 思路：动态规划
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/11
 */
public class LongestPalindrome {

    // todo 这个题。。。
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int start = 0, end = 0;
        int[][] dp = new int[chars.length][chars.length / 2 + 1];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= Math.min(i, chars.length - i); j++) {
                if (chars[i - j] == chars[i + j]) {
                    dp[i][j + 1] = 2 * j + 1;
                }
            }
        }


        return null;
    }

}
