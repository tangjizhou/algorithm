package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 *
 * @author tangjizhou
 * @since 2021/7/11
 */
public class SquaresOfASortedArray {


    @Test
    public void test() {
        int[] nums = {-5, 3, -2, -1};
        Arrays.stream(sortedSquares1(nums)).forEach(System.out::println);
    }

    public int[] sortedSquares(int[] nums) {

        int[] ret = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        ret[0] = min;
        int l = minIndex - 1, r = minIndex + 1, index = 1;
        while (l >= 0 && r < nums.length) ret[index++] = nums[l] >= nums[r] ? nums[r++] : nums[l--];
        while (l >= 0) ret[index++] = nums[l--];
        while (r < nums.length) ret[index++] = nums[r++];
        return ret;
    }

    public int[] sortedSquares1(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] ret = new int[nums.length];
        int index = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] >= nums[r] * nums[r]) {
                ret[index--] = nums[l] * nums[l];
                ++l;
            } else {
                ret[index--] = nums[r] * nums[r];
                --r;
            }
        }
        return ret;
    }

}
