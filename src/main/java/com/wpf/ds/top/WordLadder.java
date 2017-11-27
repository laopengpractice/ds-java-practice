package com.wpf.ds.top;

import com.wpf.ds.common.Vertical;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wenpengfei on 2017/11/24.
 */
public class WordLadder {

    public static boolean findLadders2(String begin, String end, List<String> wordList) {
        if (begin.equals(end)) {
            return true;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String>[] sets = new Set[10];
        sets[0] = new HashSet<>();
        sets[0].add(begin);
        sets[1] = new HashSet<>();
        sets[1].add(end);
        Set<String> visited = new HashSet<>();
        while (!sets[0].isEmpty() && !sets[1].isEmpty()) {
            int from, to;
            if (sets[0].size() < sets[1].size()) {
                from = 0;
                to = 1;
            } else {
                from = 1;
                to = 0;
            }

            Set<String> newSet = new HashSet<>();
            for (String word : sets[from]) {
                for (int i = 0; i < word.length(); ++i) {
                    char[] cArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == cArray[i]) {
                            continue;
                        }
                        cArray[i] = c;
                        String newWord = new String(cArray);
                        if (sets[to].contains(newWord)) {
                            return true;
                        }
                        if (visited.contains(newWord)) {
                            continue;
                        }
                        if (wordSet.contains(newWord)) {
                            newSet.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }

            sets[from] = newSet;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dog", "lot", "dot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        String begin = "hit";
        String end = "cog";
        System.out.println(findLadders2(begin, end, wordList));
    }
}
