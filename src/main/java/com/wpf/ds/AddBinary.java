package com.wpf.ds;

/**
 * Created by wenpengfei on 2017/9/5.
 */
public class AddBinary {

    public static String addBinary(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = s1.charAt(i) - '0' + s2.charAt(j) - '0' + carry;
            sb.append((char)(sum % 2 + '0'));
            carry = sum / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = s1.charAt(i) - '0' + carry;
            sb.append((char)(sum % 2 + '0'));
            carry = sum / 2;
            i--;
        }
        while (j >= 0) {
            int sum = s2.charAt(j) - '0' + carry;
            sb.append((char)(sum % 2 + '0'));
            carry = sum / 2;
            j--;
        }
        if (carry != 0) {
            sb.append((char)(carry + '0'));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "1"));
    }
}
