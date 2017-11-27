package com.wpf.ds.common;

import java.util.List;

/**
 * Created by wenpengfei on 2017/9/27.
 */
public class PrintUtils {

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString() + " ");
        }
        System.out.println();
    }

    public static void printInt(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printInt2D(int[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
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

    public static void printLinkList(LinkList head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
