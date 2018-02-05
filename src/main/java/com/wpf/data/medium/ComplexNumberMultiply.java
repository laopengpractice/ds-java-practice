package com.wpf.data.medium;

/**
 * Created by wenpengfei on 2017/9/18.
 */
public class ComplexNumberMultiply {

    static class ComplexNumber {
        int a;
        int b;
    }

    public static String complexNumber(String s1, String s2) {
        ComplexNumber n1 = parseComplexNumber(s1);
        ComplexNumber n2 = parseComplexNumber(s2);
        int ma = n1.a * n2.a - n1.b * n2.b;
        int mb = n1.a * n2.b + n1.b * n2.a;

        return ma + "+" + mb + "i";
    }

    public static ComplexNumber parseComplexNumber(String s) {
        int idx = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+') {
                idx = i;
                break;
            }
        }

        ComplexNumber cn = new ComplexNumber();
        cn.a = parseInteger(s, 0, idx - 1);
        cn.b = parseInteger(s, idx + 1, s.length() - 2);

        return cn;
    }

    public static int parseInteger(String s, int b, int e) {
        boolean negtive = false;
        if (s.charAt(b) == '-') {
            negtive = true;
            b++;
        } else if (s.charAt(b) == '+') {
            b++;
        }
        int n = 0;
        for (int i = b; i >= e; --i) {
            int num = s.charAt(i) - '0';
            n = n * 10 + num;
        }

        return negtive ? -n : n;
    }

    public static void main(String[] args) {
        System.out.println(complexNumber("2+3i", "3+4i"));
    }
}
