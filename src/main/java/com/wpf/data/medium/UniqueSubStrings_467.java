package com.wpf.data.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/4/25.
 */
public class UniqueSubStrings_467 {

    //...xyzabcde.... zabc ()
    public static int uniqueSubStrings(String p) {
        if (p.length() == 0) {
            return 0;
        }
        int rs = 1;
        int last = 1;
        for (int i = 1; i < p.length(); ++i) {
            char pre = p.charAt(i - 1);
            char cur = p.charAt(i);
            if (pre + 1 == cur || (pre == 'z' && cur == 'a')) {
                rs += last + 1;
                last++;
            } else {
                rs += 1;
                last = 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(uniqueSubStrings("zabofcde"));
    }
}
