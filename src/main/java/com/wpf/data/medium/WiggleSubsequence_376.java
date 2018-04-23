package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/4/23.
 */
public class WiggleSubsequence_376 {

    public static int wiggleSubsequence(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        List<Integer> longestWiggle = new ArrayList<>();
        longestWiggle.add(nums[0]);
        int i = 1;
        while (i < nums.length && nums[i] == nums[0]) {
            i++;
        }
        boolean bigger;
        if (i >= nums.length) {
            return longestWiggle.size();
        }
        bigger = nums[i] < nums[0];
        longestWiggle.add(nums[i++]);
        while (i < nums.length) {
            int last = longestWiggle.get(longestWiggle.size() - 1);
            if (nums[i] == last) {
                i++;
                continue;
            }

            if ((nums[i] > last && !bigger) || (nums[i] < last && bigger)) {
                longestWiggle.set(longestWiggle.size() - 1, nums[i]);
            } else {
                longestWiggle.add(nums[i]);
                bigger = !bigger;
            }

            i++;
        }

        return longestWiggle.size();
    }

    public static void main(String[] args) {
        System.out.println(wiggleSubsequence(new int[]{1, 3, 1, 3, 1, 3}));
    }
}
