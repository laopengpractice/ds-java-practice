package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2018/5/25.
 */
public class RemoveDigits_402 {

    //2435212  2
    public static String removeDigits(String num, int k) {
        int n = num.length();
        int remain = n - k;
        if (remain == 0) {
            return "0";
        }

        StringBuilder rs = new StringBuilder();
        int start = 0;
        while (remain > 0) {
            int minIdx = start;
            int min = num.charAt(start);
            for (int i = start + 1; i <= n - remain; ++i) {
                if (num.charAt(i) < min) {
                    min = num.charAt(i);
                    minIdx = i;
                }
            }
            rs.append((char)min);
            remain--;
            start = minIdx + 1;
        }

        String rsNum = rs.toString();
        int begin = 0;
        while (rsNum.charAt(begin) == '0') {
            begin++;
        }

        return rsNum.substring(begin);
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("10123", 2));
    }
}
