package com.wpf.data.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wenpengfei on 2018/4/28.
 */
public class WordBreak_139 {

    public static boolean wordBreak(String s, List<String> dict) {
        Set<String> sets = new HashSet<>(dict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j]) {
                    String subStr = s.substring(j, i);
                    if (sets.contains(subStr)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dicts = new ArrayList<>();
        dicts.add("apple");
        dicts.add("end");
        System.out.println(wordBreak("appleendapple", dicts));
    }
}
