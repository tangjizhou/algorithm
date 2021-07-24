package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一组数字，求使得数组之和不超过 cnt的最大limit
 * eg: [1,2,3,4,5],cnt = 10 ==> limit = 2 , if limit = 3 then cnt = 12 , explain: 1 + 2 + 3 + 3 + 3
 *
 * @author tangjizhou
 * @since 2021/7/24
 */
public class MaxLimitOfSum {

    @Test
    public void test() {
        int[] nums = {1, 2, 11, 4, 3, 5, 6, 7, 8, 9, 10, 20, 21, 22, 23, 21, 20, 100};
        // Assert.assertEquals(4, calc(nums, 15));
        // Assert.assertEquals(0, calc(nums, 2));
        // Assert.assertEquals(1, calc(nums, 6));
        // Assert.assertEquals(2, calc(nums, 10));
        int limit = calc(nums, 292);
        for (int num : nums) {
            System.out.print(Math.min(num, limit) + ", ");
        }
        System.out.println();
        System.out.println(limit);
    }

    public int calc(int[] nums, int cnt) {
        int currentSum = 0, minLine = cnt / nums.length;
        Queue<Integer> queue = new LinkedList<>();
        int max = 0, totalSum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            totalSum += num;
            if (num > minLine) {
                queue.offer(num);
            }
            currentSum += Math.min(num, minLine);
        }

        if (totalSum <= cnt) return -1;
        if (cnt < nums.length) return 0;
        int preLimit = minLine;
        while (currentSum <= cnt && !queue.isEmpty()) {
            preLimit = minLine;
            minLine += Math.max(1, (cnt - currentSum) / queue.size());
            for (int i = 0; i < queue.size() && currentSum <= cnt; i++) {
                Integer value = queue.poll();
                if (value <= minLine) {
                    currentSum += (value - preLimit);
                } else {
                    currentSum += (minLine - preLimit);
                    queue.offer(value);
                }
            }
        }
        return Math.min(preLimit, max);
    }


}
