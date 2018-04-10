package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/4/10.
 */
public class PredictTheWinner {

    public static boolean predictWinner(int[] nums) {
        if (nums.length < 2) {
            return true;
        }


        int[][] first = new int[nums.length][nums.length];
        int[][] second = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; ++i) {
            first[i][i] = nums[i];
        }

        for (int i = 2; i <= nums.length; ++i) {
            for (int j = 0; j <= nums.length - i; ++j) {
                if (second[j][j + i -2] + nums[j + i - 1] > second[j + 1][j + i -1] + nums[j]) {
                    first[j][j + i - 1] = second[j][j + i - 2] + nums[j + i - 1];
                    second[j][j + i - 1] = first[j][j + i - 2];
                } else {
                    first[j][j + i - 1] = second[j + 1][j + i -1] + nums[j];
                    second[j][j + i - 1] = first[j + 1][j + i -1];
                }
            }
        }

        return first[0][nums.length - 1] > second[0][nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(predictWinner(new int[]{1, 5, 23, 7}));
    }
}
