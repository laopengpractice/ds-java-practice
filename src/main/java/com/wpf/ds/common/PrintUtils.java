package com.wpf.ds.common;

/**
 * Created by wenpengfei on 2017/9/27.
 */
public class PrintUtils {

    public static void print(String[][] s) {
        if (s == null) {
            System.out.println(s);
            return;
        }
        for (String[] line : s) {
            for (String word : line) {
                System.out.print("\"" + word + "\" ");
            }
            System.out.println();
        }
    }
}
