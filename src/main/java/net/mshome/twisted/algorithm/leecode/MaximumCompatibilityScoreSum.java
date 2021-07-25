package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/weekly-contest-251/problems/maximum-compatibility-score-sum/
 * 最大兼容性评分和
 *
 * @author tangjizhou
 * @since 2021/7/25
 */
public class MaximumCompatibilityScoreSum {


    @Test
    public void test() {

        int[][] students = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        int[][] mentors = {{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        maxCompatibilitySum(students, mentors);
    }


    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[][] score = new int[students.length][mentors.length];

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < mentors.length; j++) {
                score[i][j] = calcMatchScore(students[i], mentors[j]);
            }
        }

        Set<Integer> selectedMentor = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        dfs(score, selectedMentor, 0, 0, set);

        int max = 0;
        for (Integer v : set) {
            max = Math.max(max, v);
        }
        return max;
    }

    private int calcMatchScore(int[] student, int[] mentor) {
        int match = 0;
        for (int i = 0; i < student.length; i++) {
            match += (student[i] ^ mentor[i]) == 0 ? 1 : 0;
        }
        return match;
    }

    private void dfs(int[][] score, Set<Integer> selectedMentors, int i, int total, Set<Integer> ret) {
        if (i == score.length) {
            ret.add(total);
            return;
        }
        for (int j = 0; j < score[i].length; j++) {
            if (!selectedMentors.contains(j)) {
                selectedMentors.add(j);
                total += score[i][j];
                dfs(score, selectedMentors, i + 1, total, ret);
                selectedMentors.remove(j);
                total -= score[i][j];
            }
        }
    }

}
