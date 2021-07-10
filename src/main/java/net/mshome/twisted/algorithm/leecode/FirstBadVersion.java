package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 第一个错误的版本
 *
 * @author tangjizhou
 * @since 2021/7/10
 */
public class FirstBadVersion {

    int[] versions = {0, 0, 0, 1, 1};

    @Test
    public void test() {
        Assert.assertEquals(4, firstBadVersion(versions.length));

    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int middle = (left + right) / 2;
            boolean badVersion = isBadVersion(middle);
            if (badVersion) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return versions[version - 1] == 1;
    }

}
