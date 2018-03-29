package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/3/29.
 */
public class FindMaxLength525 {

    static int max = 50000;

    public static int findMaxLength(int[] nums) {
        int[] hash = new int[max * 2 + 1];

        int cnt = 0;
        int rs = 0;
        for (int i = 0; i < nums.length; ++i) {
            cnt += nums[i] == 0 ? -1 : 1;
            if (cnt == 0) {
                if (rs < i + 1) {
                    rs = i + 1;
                }
            } else {
                int idx = cnt + max;
                if (hash[idx] != 0) {
                    if (i + 1 - hash[idx] > rs) {
                        rs = i + 1 - hash[idx];
                    }
                } else {
                    hash[idx] = i + 1;
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0};
        System.out.println(findMaxLength(nums));
    }
}
