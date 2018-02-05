package com.wpf.data;

/**
 * Created by wenpengfei on 2017/10/20.
 */
public class MaxNeighborDiff {

    public static int maxNeighborDiff(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0], min = nums[1];
        for (int n : nums) {
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
        }

        double gap = (max - min) / (double)(nums.length - 1);
        boolean[] use = new boolean[nums.length];
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        for (int n : nums) {
            int idx = (int)((n - min) / gap);
            if (!use[idx]) {
                use[idx] = true;
                maxs[idx] = n;
                mins[idx] = n;
            } else {
                if (maxs[idx] < n) {
                    maxs[idx] = n;
                }
                if (mins[idx] > n) {
                    mins[idx] = n;
                }
            }
        }

        int rs = 0, pre = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (!use[i]) {
                continue;
            }
            if (mins[i] - maxs[pre] > rs) {
                rs = mins[i] - maxs[pre];
            }
            pre = i;
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 4, 12, 20, 18, 21, 35, 50, 39};
        System.out.println(maxNeighborDiff(nums));
    }
}
