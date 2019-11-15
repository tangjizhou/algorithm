package net.mshome.twisted.algorithm.leecode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 两数之和
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/5
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.get(result) != null && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }
        return new int[]{-1, -1};


    }

    @Test
    public void test() {
        int[] s = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(s, 6)));
    }


}
