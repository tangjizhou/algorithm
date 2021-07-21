package net.mshome.twisted.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 组合
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> all = new ArrayList<>();
        combineHelper(1, n, k, new ArrayList<>(), all);
        return all;
    }


    public void combineHelper(int start, int end, int k, List<Integer> values, List<List<Integer>> all) {
        if (values.size() == k) {
            all.add(new ArrayList<>(values));
            return;
        }
        if (end - start + 1 < k - values.size()) return;
        for (int i = start; i <= end; i++) {
            values.add(i);
            combineHelper(i + 1, end, k, values, all);
            values.remove(Integer.valueOf(i));
        }
    }

}
