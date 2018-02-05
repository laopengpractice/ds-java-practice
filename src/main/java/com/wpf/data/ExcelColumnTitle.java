package com.wpf.data;

/**
 * Created by wenpengfei on 2017/9/13.
 */
public class ExcelColumnTitle {

    public static String excelColumnTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remain = n % 26;
            if (remain == 0) {
                sb.append('Z');
                n -= 26;
            } else {
                sb.append((char)(remain - 1 + 'A'));
            }
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(excelColumnTitle(51));
    }
}
