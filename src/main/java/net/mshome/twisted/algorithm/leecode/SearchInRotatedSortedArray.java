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
        int[] nums = {3, 1};
        Assert.assertEquals(1, search2(nums, 1));
        Assert.assertEquals(0, search2(nums, 3));
    }

    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && nums[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
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
