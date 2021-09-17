package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
 * 搜索旋转排序数组
 *
 * @author tangjizhou
 * @since 2021/9/17
 */
public class SearchInRotatedSortedArray {

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(4, search1(nums, 0));
        Assert.assertEquals(-1, search1(nums, 3));
    }

    public int search1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[l] < nums[middle]) {
                if (nums[l] <= target && nums[middle] > target) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }
            } else {
                if (nums[middle] < target && nums[r] >= target) {
                    l = middle + 1;
                } else {
                    r = middle - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (target == nums[l]) return l;
        if (target == nums[r]) return r;

        while (l < r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] > nums[l]) {
                l = middle;
            } else {
                r = middle;
            }
        }

        if (nums[0] < target) {
            l = 0;
        } else {
            l = l + 1;
            r = nums.length - 1;
        }

        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] < target) {
                l = middle + 1;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
