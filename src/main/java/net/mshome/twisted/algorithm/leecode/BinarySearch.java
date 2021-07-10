package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 二分查找
 *
 * @author tangjizhou
 * @since 2021/5/19
 */
public class BinarySearch {

    @Test
    public void test() {
        Assert.assertEquals(1, search(new int[]{0, 2, 5}, 2));
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) right = middle - 1;
            else if (nums[middle] < target) left = middle + 1;
        }
        return -1;
    }

}
