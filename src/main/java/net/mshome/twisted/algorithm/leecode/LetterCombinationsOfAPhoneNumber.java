package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/2/11
 */
public class LetterCombinationsOfAPhoneNumber {

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of('1', "", '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz", '0', "");
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        // List<String> results = new ArrayList<>();
        // backtrace(new StringBuilder(0), map, digits, 0, results);
        // return results;
        return bfs(digits, map);

    }

    // 回溯，深度优先
    public void backtrace(StringBuilder current, Map<Character, String> map, String digits,
                          int level, List<String> results) {
        if (current.length() == digits.length()) {
            results.add(current.toString());
            return;
        }

        String chars = map.get(digits.charAt(level));
        for (char c : chars.toCharArray()) {
            current.append(c);
            backtrace(current, map, digits, level + 1, results);
            current.deleteCharAt(level);
        }
    }

    // 广度优先
    public LinkedList<String> bfs(String digits, Map<Character, String> map) {
        LinkedList<String> results = new LinkedList<>();
        results.add("");
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            String s = map.get(digits.charAt(i));
            while (results.peek() != null && results.peek().length() != i + 1) {
                String poll = results.poll();
                for (char c : s.toCharArray()) {
                    results.offer(poll + c);
                }
            }
        }
        return results;
    }


}
