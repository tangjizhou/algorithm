package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 斐波那契数
 *
 * @author tangjizhou
 * @since 2021/6/2
 */
public class FibonacciNumber {

    @Test
    public void test() {

        // Assert.assertEquals(1, fib(1));
        // Assert.assertEquals(0, fib(0));
        // Assert.assertEquals(1, fib(2));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(3, fib(4));
        Assert.assertEquals(5, fib(5));

    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 0, curr = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = curr + pre;
            pre = curr;
            curr = sum;
        }
        return sum;
    }

}
