package com.wpf.data.top;

import com.wpf.data.common.PrintUtils;
import com.wpf.data.common.Vertical;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenpengfei on 2017/11/27.
 */
public class WordLadder2 {

    private static int min = Integer.MAX_VALUE;

    public static List<List<String>> findLadders(String begin, String end, List<String> words) {
        int beginIdx = wordIdx(begin, words);
        int endIdx = wordIdx(end, words);
        List<Vertical<Integer>> graph = buildGraph(words);
        List<List<String>> rs = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < graph.size(); ++i) {
            visited.add(false);
        }
        dfs(beginIdx, endIdx, graph, words, rs, l, visited);
        return rs;
    }

    private static void dfs(int b, int e ,List<Vertical<Integer>> graph, List<String> words,
        List<List<String>> rs, List<Integer> l, List<Boolean> visited) {
        if (l.size() >= min) {
            return;
        }
        Vertical<Integer> v = graph.get(b);
        l.add(b);
        visited.set(b, true);
        if (b == e) {
            List<String> wordRs = new ArrayList<>();
            for (Integer i : l) {
                wordRs.add(words.get(i));
            }
            if (min > wordRs.size()) {
                min = wordRs.size();
                rs.clear();
            }
            rs.add(wordRs);
            visited.set(b, false);
            l.remove(l.size() - 1);
            return;
        }
        v = v.next;
        while (v != null) {
            int idx = v.data;
            if (visited.get(idx)) {
                v = v.next;
                continue;
            }
            dfs(idx, e, graph, words, rs, l, visited);
            v = v.next;
        }
        l.remove(l.size() - 1);
        visited.set(b, false);
    }

    private static List<Vertical<Integer>> buildGraph(List<String> words) {
        List<Vertical<Integer>> rs = new ArrayList<>();
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < words.size(); ++i) {
            idxMap.put(words.get(i), i);
        }
        for (int i = 0; i < words.size(); ++i) {
            Vertical<Integer> v = new Vertical<>(i);
            rs.add(v);
            String word = words.get(i);
            for (int j = 0; j < word.length(); ++j) {
                for (char c = 'a'; c <= 'z'; ++c) {
                    char[] wordArray = word.toCharArray();
                    if (c == wordArray[j]) {
                        continue;
                    }
                    wordArray[j] = c;
                    String newWord = new String(wordArray);
                    Integer newIdx = idxMap.get(newWord);
                    if (newIdx != null) {
                        Vertical<Integer> post = new Vertical<>(newIdx);
                        post.next = v.next;
                        v.next = post;
                    }
                }
            }
        }

        return rs;
    }

    private static int wordIdx(String word, List<String> words) {
        int idx = words.indexOf(word);
        if (idx == -1) {
            words.add(word);
            return words.size() - 1;
        }

        return idx;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"hot", "dog", "lot", "dot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        String begin = "hit";
        String end = "cog";
        List<List<String>> rs = findLadders(begin, end, wordList);
        PrintUtils.printList(rs);
    }
}
