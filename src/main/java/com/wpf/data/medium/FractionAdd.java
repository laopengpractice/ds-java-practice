package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/10/17.
 */
public class FractionAdd {

    static class Fraction {
        private int numerator;
        private int denominator;

        public void add(Fraction fraction) {
            int n = numerator;
            int d = denominator;
            numerator *= fraction.denominator;
            denominator *= fraction.denominator;
            fraction.numerator *= d;
            fraction.denominator *= n;

            numerator += fraction.numerator;
            irreducible();
        }

        private void irreducible() {
            if (numerator == 0) {
                return;
            }
            int num = numerator;
            if (num < 0) {
                num = -num;
            }

            int factor = maxFactor(num, denominator);
            numerator /= factor;
            denominator /= factor;
        }

        public static int maxFactor(int a, int b) {
            int m = Math.max(a, b);
            int n = Math.min(a, b);
            while (m % n != 0) {
                int k = m % n;
                m = Math.max(k, n);
                n = Math.min(k, n);
            }

            return n;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public static String fractionAdd(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (Character.isDigit(s.charAt(0))) {
            s = '+' + s;
        }

        List<Fraction> fractions = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            boolean negtive = false;
            if (s.charAt(i++) == '-') {
                negtive = true;
            }
            Fraction fraction = new Fraction();
            int num = 0;
            while (s.charAt(i) != '/') {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (negtive) {
                num = -num;
            }
            fraction.numerator = num;
            i++;
            int demo = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                demo = demo * 10 + (s.charAt(i) - '0');
                i++;
            }
            fraction.denominator = demo;
            fraction.irreducible();
            fractions.add(fraction);
        }

        Fraction f = fractions.get(0);
        for (int j = 1; j < fractions.size(); ++j) {
            f.add(fractions.get(j));
        }

        return f.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionAdd("2/1-3/1+10/2+6/6"));
    }
}
