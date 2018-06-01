package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2018/6/1.
 */
public class CapTInK {

    public static List<int[]> capTinK(int[] nums, int k, int t) {
        List<int[]> rs = new ArrayList<>();
        for (int i = 0; i < nums.length - k; ++i)
            for (int j = 1; j <= k; ++j) {
                if (nums[j + i] - nums[i] <= t) {
                    int[] pair = new int[2];
                    rs.add(pair);
                }
            }

        return rs;
    }
}
