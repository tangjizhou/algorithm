package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 零钱兑换
 *
 * @author tangjizhou
 * @since 2021/6/2
 */
public class CoinChange {


    private final Map<Integer, Integer> memo = new HashMap<>();

    @Test
    public void test() {
        Assert.assertEquals(20, coinChange2(new int[]{1, 2, 5}, 100));
        Assert.assertEquals(2, coinChange2(new int[]{1}, 2));
        Assert.assertEquals(3, coinChange2(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(11, coinChange2(new int[]{1}, 11));
    }

    public int coinChange3(int[] coins, int amount) {
        int[] coinNo = new int[amount + 1];
        Arrays.fill(coinNo, amount + 1);
        coinNo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                coinNo[i] = Math.min(coinNo[i], coinNo[i - coin] + 1);
            }
        }
        return coinNo[amount] == amount + 1 ? -1 : coinNo[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int min = amount + 1;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) continue;
            min = Math.min(min, sub + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo.get(amount) != null) return memo.get(amount);
        int min = amount + 1;
        for (int coin : coins) {
            int sub = coinChange2(coins, amount - coin);
            if (sub == -1) continue;
            min = Math.min(min, sub + 1);
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        memo.put(amount, min);
        return min;
    }


}
