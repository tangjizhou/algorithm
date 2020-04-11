package net.mshome.twisted.algorithm.leecode;

/**
 * 4. 寻找两个有序数组的中位数，要求算法的时间复杂度为 O(log(m + n))
 * 思路：
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 2, 2, 2};
        int[] nums2 = new int[]{3, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 时间复杂度 O(m+n / 2)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0, totalLength = total.length;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                total[k++] = nums2[j++];
            } else if (j == nums2.length) {
                total[k++] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                total[k++] = nums1[i++];
            } else {
                total[k++] = nums2[j++];
            }
            // 取一半长度的数就够了
            if (k == totalLength / 2 + 1) {
                break;
            }
        }
        return totalLength % 2 == 0 ? (total[totalLength / 2 - 1] + total[totalLength / 2]) / 2d
                : total[totalLength / 2];
    }

    /**
     * 时间复杂度 O(log(m+n))
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {





        return 0;

    }


}