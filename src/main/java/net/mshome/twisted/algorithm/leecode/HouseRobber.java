package net.mshome.twisted.algorithm.leecode;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre = 0, curr = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int max = Math.max(pre + nums[i - 1], curr);
            pre = curr;
            curr = max;
        }
        return curr;
    }

}
