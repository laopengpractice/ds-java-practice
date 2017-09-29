package com.wpf.ds.common;

/**
 * Created by wenpengfei on 2017/9/27.
 */
public class PrintUtils {

    public static void printInt(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> void print1D(T[] s) {
        for (T t : s) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    public static <T> void print2D(T[][] s) {
        if (s == null) {
            System.out.println(s);
            return;
        }
        for (T[] line : s) {
            for (T word : line) {
                System.out.print("\"" + word + "\" ");
            }
            System.out.println();
        }
    }
}
