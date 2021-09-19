package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转排序数组中的最小值
 *
 * @author tangjizhou
 * @since 2021/9/19
 */
public class FindMinimumInRotatedSortedArray {

    @Test
    public void test() {
        int[] a = {3, 1, 2};
        Assert.assertEquals(1, findMin1(a));
    }

    public int findMin1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < min) min = nums[m];
            if (nums[l] <= nums[m]) {
                if (nums[l] < min) {
                    min = nums[l];
                }
                l = m + 1;
            } else {
                if (nums[m] < min) {
                    min = nums[m];
                }
                r = m - 1;
            }
        }
        return min;
    }

}
