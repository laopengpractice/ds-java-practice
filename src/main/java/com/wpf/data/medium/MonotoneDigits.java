package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/2/6.
 */
public class MonotoneDigits {

    public static int monotoneDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int num = 1;
        int tmp = n;
        int exp = 1;
        while (tmp / 10 != 0) {
            num++;
            tmp /= 10;
            exp *= 10;
        }

        int[] rs = new int[num];
        int i = 0;
        int tmpRs = 0;
        while (i < num) {
            int j;

            if (i == 0) {
                j = tmp;
            } else {
                j = rs[i - 1];
            }

            while (j <= 9) {
                if ((tmpRs * 10 + j) * exp > n) {
                    break;
                }

                j++;
            }
            j--;

            if (i > 0 && j < rs[i - 1]) {
                rs[i - 1]--;
                int k = i - 1;
                while (k > 0 && rs[k] < rs[k - 1]) {
                    rs[k - 1]--;
                    k--;
                }
                tmpRs = 0;
                for (int m = 0; m <= k; ++m) {
                    tmpRs = tmpRs * 10 + rs[m];
                }
                i = k + 1;
            } else {
                rs[i] = j;
                tmpRs = tmpRs * 10 + j;
                i++;
                exp /= 10;
            }
        }

        return tmpRs;
    }

    public static void main(String[] args) {
        int rs = monotoneDigits(332);
        System.out.println(rs);
    }
}
