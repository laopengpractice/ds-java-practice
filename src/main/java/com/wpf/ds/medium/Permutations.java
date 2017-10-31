package com.wpf.ds.medium;

import com.wpf.ds.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/31.
 */
public class Permutations {

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        help(nums, 0, rs);

        return rs;
    }

    public static void help(int[] nums, int b, List<List<Integer>> rs) {
        if (b == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            rs.add(list);
            return;
        }

        for (int i = b; i < nums.length; ++i) {
            swap(nums, b, i);
            help(nums, b + 1, rs);
            swap(nums, b, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        List<List<Integer>> rs = permutations(new int[]{1, 2});
        for (List<Integer> list : rs) {
            PrintUtils.printList(list);
        }
    }
}
