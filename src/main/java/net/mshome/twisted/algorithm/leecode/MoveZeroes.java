package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 *
 * @author tangjizhou
 * @since 2021/7/12
 */
public class MoveZeroes {

    @Test
    public void test() {
        int[] nums = {1, 0, 1};
        moveZeroes1(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void moveZeroes1(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                ++left;
            }
            ++right;

        }
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) continue;
            int zeroIndex = i;
            for (int j = i + 1; zeroIndex < nums.length - count - 1 && j < nums.length; j++) {
                if (nums[j] == 0) continue;
                int temp = nums[j];
                nums[j] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex = j;
            }
            ++count;
        }
    }

}
