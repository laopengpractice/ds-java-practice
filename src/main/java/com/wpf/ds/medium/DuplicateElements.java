package com.wpf.ds.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/9/20.
 */
public class DuplicateElements {


    public static List<Integer> duplicateElements(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i + 1 == nums[i] || nums[i] == 0) {
                continue;
            }
            if (nums[nums[i] - 1] == nums[i]) {
                rs.add(nums[i]);
                nums[i] = 0;
            } else {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
                --i;
            }
        }

        return rs;
    }

    public static List<Integer> duplicate2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int loc = Math.abs(nums[i]) - 1;
            if (nums[loc] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[loc] = -nums[loc];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> rs = duplicateElements(new int[]{1, 1, 2, 3, 2, 3});
        for (int n : rs) {
            System.out.println(n);
        }
    }
}
