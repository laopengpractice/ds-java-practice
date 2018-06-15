package com.wpf.data.other;

import com.wpf.data.common.PrintUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public class TernarySearchTree implements SearchTree {

    private static class Node {
        private char c;
        private Node left;
        private Node mid;
        private Node right;
        private Node parent;
        private boolean word;

        public Node(char c) {
            this.c = c;
        }
    }

    private Node root;

    public TernarySearchTree() {
    }

    public TernarySearchTree(List<String> words) {
        this();
        Collections.sort(words);
        int mid = (0 + words.size()) / 2;
        if (mid < words.size()) {
            add(words.get(mid));
        }
        int l = mid - 1, r = mid + 1;
        while (l >= 0 && r < words.size()) {
            add(words.get(l));
            add(words.get(r));
            l--;
            r++;
        }
        if (l >= 0) {
            add(words.get(l));
        }
        if (r < words.size()) {
            add(words.get(r));
        }
    }

    @Override
    public void add(String word) {
        Node root = add(this.root, word);
        if (this.root == null) {
            this.root = root;
        }
    }

    public void add2(String word) {
        Node node = this.root;
        Node p = null;
        for (char c : word.toCharArray()) {
            while (node != null && node.c != c) {
                p = node;
                if (node.c > c) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (node == null) {
                node = new Node(c);
                if (p.c > c) {
                    p.left = node;
                } else {
                    p.right = node;
                }
                node.parent = p;
            }

            p = node;
            node = node.mid;
        }

        p.word = true;
    }

    private Node add(Node root, String word) {
        if (word.isEmpty()) {
            return null;
        }

        char c = word.charAt(0);
        if (root == null) {
            root = new Node(c);
        }
        Node p = null;
        Node node = root;
        while (node != null && node.c != c) {
            if (node.c > c) {
                p = node;
                node = node.left;
            } else {
                p = node;
                node = node.right;
            }
        }

        if (node == null) {
            node = new Node(c);
            if (p.c > c) {
                p.left = node;
            } else {
                p.right = node;
            }
        }

        Node mid = add(node.mid, word.substring(1));
        if (word.length() == 1) {
            node.word = true;
        }
        if (node.mid == null) {
            node.mid = mid;
            mid.parent = node;
        }

        return root;
    }

    @Override
    public List<String> search(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            while (node != null && node.c != c) {
                if (node.c > c) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (node == null) {
                break;
            }

            node = node.mid;
        }

        List<String> rs = allWords(prefix, node);
        if (node != null && node.parent.word) {
            rs.add(prefix);
        }

        return rs;
    }

    private List<String> allWords(String prefix, Node root) {
        List<String> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        if (root.word) {
            rs.add(prefix + root.c);
        }

        rs.addAll(allWords(prefix + root.c, root.mid));
        rs.addAll(allWords(prefix, root.left));
        rs.addAll(allWords(prefix, root.right));

        return rs;
    }

    @Override
    public void remove(String word) {

    }

    @Override
    public List<String> match(String regex) {
        return null;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("wpf", "wenpf", "wenpengfei", "wpfei", "wpengf");
        TernarySearchTree searchTree = new TernarySearchTree(words);
        List<String> searchRs = searchTree.search("pf");
        PrintUtils.printList(searchRs);
    }
}
