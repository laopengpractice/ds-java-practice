package com.wpf.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/9/7.
 */
public class WordPattern {

    public static boolean wordPattern(String pat, String sentence) {
        String[] cToStr = new String[128];
        Map<String, Character> strToC = new HashMap<>();
        int j = 0;
        int idx = 0;
        for (int i = 0; i <= sentence.length(); ++i) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                if (i > idx) {
                    if (j >= pat.length()) {
                        return false;
                    }
                    String subStr = sentence.substring(idx, i);
                    String str = cToStr[pat.charAt(j)];
                    Character c = strToC.get(subStr);
                    if (str == null && c == null) {
                        cToStr[pat.charAt(j)] = subStr;
                        strToC.put(subStr, pat.charAt(j));
                    } else if (str == null || c == null) {
                        return false;
                    } else {
                        if (!str.equals(subStr) || !c.equals(pat.charAt(j))) {
                            return false;
                        }
                    }
                    j++;
                }
                while (i + 1 < sentence.length() && sentence.charAt(i + 1) == ' ') {
                    i++;
                }
                idx = i + 1;
            }
        }

        if (j < pat.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abbaa", " aba tiger  tiger  aba"));
    }
}
