package com.wpf.ds.top;

/**
 * Created by wenpengfei on 2017/11/24.
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasPoint = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNum = true;
                continue;
            }

            switch (c) {
                case '+':
                case '-':
                    if (i > 0 && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    break;
                case 'e':
                    if (!hasNum || hasE) {
                        return false;
                    }
                    hasNum = false;
                    hasE = true;
                    break;
                case '.':
                    if (!hasNum || hasPoint) {
                        return false;
                    }
                    hasPoint = true;
                    break;
                default:
                    return false;
            }
        }

        return hasNum;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("-12.3e1e"));
    }
}
