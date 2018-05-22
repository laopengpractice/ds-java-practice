package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wenpengfei on 2018/5/17.
 */
public class BurstBollons_312 {

    //dp[i...j] = Math.max();
    public static int test(List<Integer> nums) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int rs = 0;
        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(i);
            int k = nums.get(i);
            if (i > 0) {
                k *= nums.get(i - 1);
            }
            if (i < nums.size() - 1) {
                k *= nums.get(i + 1);
            }
            int n = test(newNums) + k;
            if (n > rs) {
                rs = n;
            }
        }

        return rs;
    }

    public static int maxCoins(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{4, 3, 10};
        List<Integer> nums = Arrays.asList(array);
        System.out.println(test(nums));
    }
}
