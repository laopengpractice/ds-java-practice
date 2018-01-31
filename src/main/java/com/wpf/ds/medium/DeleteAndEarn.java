package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2018/1/31.
 */
public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        int max = 10000;
        int[] hash = new int[max + 1];
        for (int n : nums) {
            hash[n]++;
        }

        int sum = 0;

        for (int i = max; i > 0; --i) {
            if (hash[i] == 0) {
                continue;
            }
            int endIdx = i;
            int[] sums = new int[2];
            int idx = 0;
            while (endIdx > 0 && hash[endIdx] != 0) {
                sums[idx] += endIdx * hash[endIdx];
                idx ^= 1;
                endIdx--;
            }

            sum += Math.max(sums[0], sums[1]);
            i = endIdx;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }
}
