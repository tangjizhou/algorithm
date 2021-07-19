package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 思路：滑动窗口
 */
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test() {
        Assert.assertEquals(lengthOfLongestSubstring("aab"), 2);
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(0);
        while (left <= right && right < chars.length) {
            if (set.add(chars[right])) {
                max = Math.max(max, set.size());
                ++right;
            } else {
                set.remove(chars[left++]);
            }
        }

        return max;
    }

}