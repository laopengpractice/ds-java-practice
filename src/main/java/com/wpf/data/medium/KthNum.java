package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/11/22.
 */
public class KthNum {

    public int findKthLargest(int[] nums, int k) {
        return help(nums, 0, nums.length - 1, k);
    }
    
        private static int help(int[] nums, int b, int e, int k) {
        if (b == e) {
            return nums[b];
        }
            
        swap(nums, (b + e) / 2, e);

        int p = nums[e];
        int m = b - 1;
        int n = e;
        for (int i = b; i < n; ) {
            if (nums[i] > p) {
                m++;
                if (m != i) {
                    swap(nums, i, m);
                }
                i++;
            } else if (nums[i] < p) {
                n--;
                if (n != i) {
                    swap(nums, i, n);
                }
            } else {
                i++;
            }
        }

        if (e != n) {
            swap(nums, e, n);
            n++;
        }

        if (m - b + 1 >= k) {
            return help(nums, b, m, k);
        } else if (k > n - b) {
            return help(nums, n, e, k - n + b);
        }

        return p;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
