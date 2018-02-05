package com.wpf.data;

import java.util.Arrays;

/**
 * Created by wenpengfei on 2017/9/12.
 */
public class DiffPairs {


    public static int diffPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1;
        if (k < 0) {
            k = Math.abs(k);
        }
        int rs = 0;
        while (j < nums.length) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                j++;
                continue;
            }
            if (i == j) {
                j++;
            } else {
                int dif = nums[j] - nums[i];
                if(dif == k) {
                    rs++;
                    i++;
                    j++;
                } else if (dif > k) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return rs;
    }
}
