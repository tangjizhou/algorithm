package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/contest/weekly-contest-251/problems/sum-of-digits-of-string-after-convert/
 * 字符串转化后的各位数字之和
 *
 * @author tangjizhou
 * @since 2021/7/25
 */
public class SumOfDigitsOfStringAfterConvert {

    @Test
    public void test() {
        System.out.println(getLucky("leetcode", 2));
    }


    public int getLucky(String s, int k) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int no = s.charAt(i) - 'a' + 1;
            total += no > 9 ? (no / 10 + no % 10) : no;
        }

        for (int i = 0; i < k - 1; i++) {
            int sum = 0;
            while (total > 0) {
                sum += total % 10;
                total /= 10;
            }
            total = sum;
        }
        return total;
    }


}
