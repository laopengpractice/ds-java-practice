package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenpengfei on 2017/11/8.
 */
public class LexOrder {

    public static List<Integer> lexOrder(int n) {
        List<Integer> rs = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            rs.add(i);
            while (i * 10 <= n) {
                rs.add(i * 10);
                i = i * 10;
            }
            if (i + 1 > n || i % 10 == 9) {
                i /= 10;
                while (i % 10 == 9) {
                    i /= 10;
                }
                if (i == 0) {
                    break;
                }
            }
            i++;
        }

        return rs;
    }

    public static void main(String[] args) {
        List<Integer> rs = lexOrder(299);
        PrintUtils.printList(rs);
    }
}
