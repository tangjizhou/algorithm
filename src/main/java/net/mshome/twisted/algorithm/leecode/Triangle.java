package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 三角形最小路径和
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class Triangle {

    @Test
    public void test() {
        List<List<Integer>> triangle =
                List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        List<List<Integer>> triangle1 = List.of(List.of(-10), List.of(1, 2));
        List<List<Integer>> triangle2 = List.of(List.of(-1), List.of(3, 2), List.of(-3, 1, -1));
        List<List<Integer>> triangle3 = List.of(List.of(-1), List.of(2, 3), List.of(1, -1, -3));
        Assert.assertEquals(-1, minimumTotalDP(triangle3));
    }

    public int minimumTotalDP(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE >> 1);
        }

        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = triangle.get(1).get(0) + dp[0][0];
        dp[1][1] = triangle.get(1).get(1) + dp[0][0];

        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][0] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }
        return min;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalHelper(triangle.get(1), 0, 1, triangle) + triangle.get(0).get(0);
    }

    public int minimumTotalHelper(List<Integer> values, int offset, int level, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return Math.min(values.get(offset), values.get(offset + 1));
        }
        List<Integer> nextLevelValues = triangle.get(level + 1);
        return Math.min(minimumTotalHelper(nextLevelValues, offset, level + 1, triangle) + values.get(offset),
                minimumTotalHelper(nextLevelValues, offset + 1, level + 1, triangle) + values.get(offset + 1));
    }

}
