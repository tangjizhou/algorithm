package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author tangjizhou
 * @since 2021/8/26
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binSearch(nums, target);
        int right = binSearch(nums, target + 1);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};

    }

    private int binSearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + right >> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2 + 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] == target) {
                left = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return left;
    }

}
