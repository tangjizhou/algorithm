package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 搜索插入位置
 *
 * @author tangjizhou
 * @since 2021/7/10
 */
public class SearchInsertPosition {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 5, 6};
        Assert.assertEquals(0, searchInsert(nums, 0));
        Assert.assertEquals(5, searchInsert(nums, 7));

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return left;
    }

}
