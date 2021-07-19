package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 字符串的排列
 *
 * @author tangjizhou
 * @since 2021/7/17
 */
public class PermutationInString {

    @Test
    public void test() {
        Assert.assertEquals(true, checkInclusion2("a", "ab"));
    }

    public boolean checkInclusion2(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length > s2.length()) return false;

        int[] difference = new int[26];
        for (int i = 0; i < s1Length; i++) {
            --difference[s1.charAt(i) - 'a'];
            ++difference[s2.charAt(i) - 'a'];
        }

        long diff = Arrays.stream(difference).filter(v -> v != 0).count();
        if (diff == 0) return true;
        for (int i = s1Length; i < s2Length; i++) {
            char in = s2.charAt(i);
            char out = s2.charAt(i - s1Length);
            if (in == out) continue;

            diff = difference[in - 'a'] == 0 ? ++diff : diff;
            ++difference[in - 'a'];
            diff = difference[in - 'a'] == 0 ? --diff : diff;

            diff = difference[out - 'a'] == 0 ? ++diff : diff;
            --difference[out - 'a'];
            diff = difference[out - 'a'] == 0 ? --diff : diff;
            if (diff == 0) return true;
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length > s2.length()) return false;

        int[] s1Position = new int[26];
        int[] s2Position = new int[26];
        for (int i = 0; i < s1Length; i++) {
            s1Position[s1.charAt(i) - 'a']++;
            s2Position[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Position, s2Position)) return true;

        for (int i = s1Length; i < s2Length; i++) {
            s2Position[s2.charAt(i) - 'a']++;
            s2Position[s2.charAt(i - s1Length) - 'a']--;
            if (Arrays.equals(s1Position, s2Position)) return true;
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            dict.put(s1.charAt(i), dict.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, total = s1.length();
        while (left <= right && right < s2.length()) {
            Integer count = dict.get(s2.charAt(right));
            if (count != null) { // 表示存在此字符
                if (count > 0) {
                    dict.put(s2.charAt(right), count - 1);
                    --total;
                    ++right;
                    if (total == 0) return true;
                } else {
                    dict.put(s2.charAt(left), dict.get(s2.charAt(left)) + 1);
                    ++left;
                    ++total;
                }
            } else {
                // 不存在此字符，移动左侧指针到右侧节点
                while (left < right) {
                    dict.put(s2.charAt(left), dict.get(s2.charAt(left)) + 1);
                    ++left;
                    ++total;
                }
                ++left;
                ++right;
            }
        }
        return false;
    }

}
