package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/10/31.
 */
public class MagicalString {

    public static int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 2;
        num[2] = 2;
        int idx = 2;
        int k = 3;
        int rs = 1;
        while (k < n) {
            int pre = num[k - 1] == 1 ? 2 : 1;
            if (num[idx] == 2) {
                num[k++] = pre;
                num[k++] = pre;
            } else {
                num[k++] = pre;
            }
            if (pre == 1) {
                rs += num[idx];
            }
            idx++;
        }

        if (num[n] == 1) {
            rs--;
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(magicalString(10));
    }
}
