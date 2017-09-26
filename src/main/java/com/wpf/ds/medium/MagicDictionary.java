package com.wpf.ds.medium;

import com.wpf.ds.common.TrieNode;

/**
 * Created by wenpengfei on 2017/9/25.
 */
public class MagicDictionary {

    private TrieNode root = new TrieNode();

    public void buildDictonary(String[] strs) {
        for (String str : strs) {
            TrieNode p = root;
            for (char c : str.toCharArray()) {
                int idx = c - 'a';
                TrieNode child = p.children[idx];
                if (child == null) {
                    child = new TrieNode();
                }
                p.children[idx] = child;
                p = child;
            }
            p.word = true;
        }
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            TrieNode t = p.children[idx];
            if(t != null) {
                p = t;
            } else {
                String suffix = word.substring(i + 1);
                for (TrieNode child : p.children) {
                    if (child == null) {
                        continue;
                    }
                    if (exist(suffix, child)) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

    private boolean exist(String suffix, TrieNode root) {
        TrieNode p = root;
        for (char c : suffix.toCharArray()) {
            p = p.children[c - 'a'];
            if (p == null) {
                return false;
            }
        }

        return p.word;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDictonary(new String[]{"hello", "world", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("word"));
        System.out.println(magicDictionary.search("worad"));
        System.out.println(magicDictionary.search("worae"));
    }
}
