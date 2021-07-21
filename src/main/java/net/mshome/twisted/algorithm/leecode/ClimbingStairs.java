package net.mshome.twisted.algorithm.leecode;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int ret = 0, pre = 0, curr = 1;
        for (int i = 1; i <= n; i++) {
            ret = pre + curr;
            pre = curr;
            curr = ret;
        }
        return ret;
    }

}
