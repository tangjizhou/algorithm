package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/contest/weekly-contest-251/problems/largest-number-after-mutating-substring/
 * 子字符串突变后可能得到的最大整数
 *
 * @author tangjizhou
 * @since 2021/7/25
 */
public class LargestNumberAfterMutatingSubstring {

    @Test
    public void test() {
        System.out.println(maximumNumber1("334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
    }

    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        boolean changed = false;
        for (int i = 0; i < chars.length; i++) {
            int no = num.charAt(i) - '0';
            if (no < change[no]) {
                chars[i] = (char) (change[no] + '0');
                changed = true;
            } else if (no > change[no] && changed) {
                break;
            }
        }
        return new String(chars);
    }

    public String maximumNumber1(String num, int[] change) {
        char[] chars = num.toCharArray();
        int i = 0;
        for (; i < chars.length && chars[i] - '0' >= change[chars[i] - '0']; ++i) ;
        for (; i < chars.length && chars[i] - '0' < change[chars[i] - '0']; ++i)
            chars[i] = (char) (change[chars[i] - '0'] + '0');
        return new String(chars);
    }


}
