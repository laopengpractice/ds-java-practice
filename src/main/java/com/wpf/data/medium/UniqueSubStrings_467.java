package com.wpf.data.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/4/25.
 */
public class UniqueSubStrings_467 {

    //...xyzabcde.... zabc ()
    public static int uniqueSubStrings(String p) {
        Set<String> patterns = new HashSet<>();
        int rs = 0;
        for (int i = 0; i < p.length(); ++i) {
            StringBuilder last = new StringBuilder();
            boolean match = true;
            for (int j = 1; i + j <= p.length(); ++j) {
                int idx = i + j - 1;
                if (j == 1) {
                    if (!patterns.contains(Character.toString(p.charAt(idx)))) {
                        patterns.add(Character.toString(p.charAt(idx)));
                        rs++;
                    }
                    last.append(p.charAt(idx));
                    continue;
                }

                char c1 = last.toString().charAt(last.length() - 1);
                char c2 = p.charAt(idx);
                if (match && (c1 + 1 == c2 || (c1 == 'z' && c2 == 'a'))) {
                    last.append(p.charAt(idx));
                    if (!patterns.contains(last.toString())) {
                        patterns.add(last.toString());
                        rs++;
                    }
                } else {
                    match = false;
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        System.out.println(uniqueSubStrings("zabofcde"));
    }
}
