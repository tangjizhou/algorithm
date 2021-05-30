package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 子集
 *
 * @author tangjizhou
 * @since 2021/5/30
 */
public class Subsets {

    @Test
    public void test() {
        List<List<Integer>> subsets = subsetsByMask(new int[]{1, 2, 3});
        subsets.forEach(System.out::println);
    }


    public List<List<Integer>> subsetsBFS(int[] nums) {
        LinkedList<List<Integer>> subsets = new LinkedList<>();
        subsets.offer(new ArrayList<>());
        for (int k : nums) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> poll = subsets.poll();
                List<Integer> newOne = new ArrayList<>(poll);
                newOne.add(k);
                subsets.offer(newOne);
                subsets.offer(poll);
            }
        }
        return subsets;
    }

    public List<List<Integer>> subsetsDFS(int[] nums) {
        LinkedList<List<Integer>> subsets = new LinkedList<>();
        subsetsDFSHelper(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public void subsetsDFSHelper(int[] num, int k, List<Integer> subset, List<List<Integer>> ret) {
        if (k >= num.length) {
            ret.add(new ArrayList<>(subset));
            return;
        }
        Integer i = num[k];
        subset.add(i);
        subsetsDFSHelper(num, k + 1, subset, ret);
        subset.remove(i);
        subsetsDFSHelper(num, k + 1, subset, ret);
    }


    public List<List<Integer>> subsetsByMask(int[] nums) {
        int length = nums.length;
        int mask = 0;
        for (int i = 0; i < length; i++) {
            System.out.println(mask << i);
        }

        return Collections.emptyList();
    }


}
