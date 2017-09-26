package com.wpf.ds.medium;

/**
 * Created by wenpengfei on 2017/9/25.
 */
public class BeautifulArrangement {

    private static int cnt;

    public static int beautifulArrangement(int n) {
        if (n == 0) {
            return 0;
        }
        boolean[] use = new boolean[n];
        help(0, n, use);
        return cnt;
    }

    private static void help(int k, int n, boolean[] use) {
        if(k == n) {
            cnt++;
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!use[i - 1]) {
                if (i % (k + 1) == 0 || (k + 1) % i == 0) {
                    use[i - 1] = true;
                    help(k + 1, n, use);
                    use[i - 1] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        beautifulArrangement(3);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(cnt);
    }
}
