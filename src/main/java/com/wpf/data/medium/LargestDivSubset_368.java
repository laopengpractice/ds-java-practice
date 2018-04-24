package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import java.util.*;

/**
 * Created by wenpengfei on 2018/4/24.
 */
public class LargestDivSubset_368 {

    //2,4,8,16
    public static List<Integer> maxSubset(int[] nums) {
        Arrays.sort(nums);
        int[] cnt = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxLen = 0;
        int idx = -1;
        List<Integer> rs = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            int max = -1;
            int found = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && 1 + cnt[j] > max) {
                    max = 1 + cnt[j];
                    found = j;
                }
            }

            if (found != -1) {
                cnt[i] = cnt[found] + 1;
            } else {
                cnt[i] = 1;
            }
            pre[i] = found;

            if (cnt[i] > maxLen) {
                idx = i;
                maxLen = cnt[i];
            }
        }

        while (idx != -1) {
            rs.add(0, nums[idx]);
            idx = pre[idx];
        }

        return rs;
    }

    public static void main(String[] args) {
        List<Integer> rs = maxSubset(new int[]{1, 2, 3, 4, 8, 9, 12, 16, 24, 48, 32, 64});
        PrintUtils.printList(rs);
    }
}
