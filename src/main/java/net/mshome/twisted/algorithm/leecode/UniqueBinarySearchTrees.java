package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/2/14
 */
public class UniqueBinarySearchTrees {

    @Test
    public void test() {
        Assert.assertEquals(5, dp(3));
    }


    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        return numTrees(1, n);
    }


    public int numTrees(int start, int end) {
        int n = 0;
        if (start > end) {
            return 1;
        }

        for (int i = start; i <= end; i++) {
            int left = numTrees(start, i - 1);
            int right = numTrees(i + 1, end);
            n += left * right;
        }
        return n;
    }

    public int dp(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }


}
