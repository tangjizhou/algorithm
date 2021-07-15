package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和 II - 输入有序数组
 *
 * @author tangjizhou
 * @since 2021/7/15
 */
public class TwoSumIiInputArrayIsSorted {

    @Test
    public void test() {
        int[] numbers = {2, 3, 4};
        System.out.println(Arrays.toString(twoSum1(numbers, 4)));

    }

    public int[] twoSum1(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int search = target - numbers[i];
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int middle = l + (r - l) / 2;
                if (numbers[middle] == search) {
                    return new int[]{i + 1, middle + 1};
                } else if (numbers[middle] < search) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] < target) {
                ++l;
            } else {
                --r;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }


}
