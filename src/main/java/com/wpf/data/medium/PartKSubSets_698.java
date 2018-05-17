package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/4/20.
 */
public class PartKSubSets_698 {

    public static boolean partKSubSets(int[] nums, int k) {
        if (k <= 1) {
            return true;
        }

        if (k == nums.length) {
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] != nums[i - 1]) {
                    return false;
                }
            }

            return true;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        int[] newNums = help(nums, target);
        if (newNums == null) {
            return false;
        }
        return partKSubSets(newNums, k - 1);
    }

    private static int[] help(int[] nums, int target) {
        boolean[][] use = new boolean[nums.length + 1][target + 1];
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; ++i) {
            dp[i][0] = true;
        }

        boolean found = false;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                if (j - nums[i - 1] >= 0 && !dp[i - 1][j] && dp[i - 1][j - nums[i - 1]]) {
                    use[i][j] = true;
                    dp[i][j] = true;
                }
            }

            if (dp[i][target]) {
                found = true;
                break;
            }
        }

        if (!found) {
            return null;
        }

        Set<Integer> idxs = new HashSet<>();
        int i = nums.length, j = target;
        while (i > 0 && j > 0) {
            if (use[i][j]) {
                idxs.add(i - 1);
                j = j - nums[i - 1];
            }
            i = i - 1;
        }

        List<Integer> rs = new ArrayList<>();
        for (int iter = 0; iter < nums.length; ++iter) {
            if (!idxs.contains(iter)) {
                rs.add(nums[iter]);
            }
        }

        int[] arr = new int[rs.size()];
        for (int t = 0; t < rs.size(); ++t) {
            arr[t] = rs.get(t);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(partKSubSets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5));
    }
}
