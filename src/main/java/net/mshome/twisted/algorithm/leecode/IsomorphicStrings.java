package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 * 同构字符串
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/12/27
 */
public class IsomorphicStrings {

    @Test
    public void test() {
        Assert.assertTrue(isIsomorphic("aab", "cac"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = i;
            s2t.computeIfAbsent(s.charAt(i), k -> t.charAt(index));
            t2s.computeIfAbsent(t.charAt(i), k -> s.charAt(index));

            if (!s2t.get(s.charAt(i)).equals(t.charAt(i)) || !t2s.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
