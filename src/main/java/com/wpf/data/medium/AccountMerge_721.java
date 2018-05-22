package com.wpf.data.medium;

import com.wpf.data.common.PrintUtils;

import javax.swing.*;
import java.util.*;

/**
 * Created by wenpengfei on 2018/5/21.
 */
public class AccountMerge_721 {

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); ++i) {
                List<String> found = map.get(list.get(i));
                if (found == null) {
                    map.put(list.get(i), list);
                } else {
                    for (int j = 1; j < list.size(); ++j) {
                        if (map.get(list.get(j)) == found) {
                            continue;
                        }
                        found.add(list.get(j));
                        map.put(list.get(j), found);
                    }
                    break;
                }
            }
        }

        List<List<String>> rs = new ArrayList<>();
        for (List<String> l : map.values()) {
            boolean found = false;
            for (int i = 0; i < rs.size(); ++i) {
                if (l == rs.get(i)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                rs.add(l);
            }
        }

        return rs;
    }

    private static List<List<String>> testCase() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("wpf");
        l.add("wpf@126.com");
        l.add("wenpf@126.com");
        l.add("wenpengfei@126.com");
        accounts.add(l);
        l = new ArrayList<>();
        l.add("john");
        l.add("john@126.com");
        l.add("john_happy@126.com");
        accounts.add(l);
        l = new ArrayList<>();
        l.add("wpf");
        l.add("wpfei@126.com");
        l.add("wenpf@126.com");
        l.add("wpengf@126.com");
        accounts.add(l);
        l = new ArrayList<>();
        l.add("john");
        l.add("john_no@126.com");
        accounts.add(l);

        return accounts;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = testCase();
        List<List<String>> rs = accountsMerge(accounts);

        PrintUtils.printList(rs);
    }
}
