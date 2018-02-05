package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/9/25.
 */
public class OptimalDivision {

    public static String optimalDivision(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder rs = new StringBuilder();
        rs.append(nums[0]).append("/(");
        for (int i  = 1; i < nums.length - 1; ++i) {
            rs.append(nums[i]).append("/");
        }
        return rs.append(nums[(nums.length - 1)]).append(")").toString();
    }

    public static void main(String[] args) {
        System.out.println(optimalDivision(new int[]{10, 3, 4, 5, 6, 8}));
    }
}
