package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public class ArrayNesting_565 {

    public static int arrayNesting(int[] nums) {
        boolean[] rs = new boolean[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (rs[i]) {
                continue;
            }

            int step = 0;
            int t = i;
            while (!rs[t]) {
                rs[t] = true;
                step++;
                t = nums[t];
            }

            if (max < step) {
                max = step;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }
}
