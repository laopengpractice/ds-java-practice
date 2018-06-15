package com.wpf.data.other;

import java.util.*;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public class TrieTree implements SearchTree {

    private static final char WILD_CARD_CHAR = '.';

    private static class Node {
        private int cnt;
        private Map<Character, Node> children;

        public Node() {
            cnt = 0;
            children = new HashMap<>();
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public void putChild(char c, Node child) {
            children.put(c, child);
        }
    }

    private Node root;

    public TrieTree() {
        root = new Node();
    }

    public TrieTree(List<String> words) {
        this();
        for (String word : words) {
            add(word);
        }
    }

    @Override
    public void add(String word) {
        Node p = root;
        for (char c : word.toCharArray()) {
            Node tmp = p.getChild(c);
            if (tmp == null) {
                tmp = new Node();
                p.putChild(c, tmp);
            }

            p = tmp;
        }

        p.cnt++;
    }

    @Override
    public List<String> search(String prefix) {
        if (prefix.isEmpty()) {
            return new ArrayList<>();
        }

        Node p = root;
        for (char c : prefix.toCharArray()) {
            if (p == null) {
                break;
            }

            p = p.getChild(c);
        }

        List<String> descendants = new ArrayList<>();
        getAll(prefix, p, descendants);

        return descendants;
    }

    @Override
    public List<String> match(String regex) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        List<String> prefixs = new ArrayList<>();
        prefixs.add("");
        for (char c : regex.toCharArray()) {
            List<Node> tmpNodes = new ArrayList<>();
            List<String> tmpPrefixs = new ArrayList<>();
            if (c == WILD_CARD_CHAR) {
                for (int i = 0; i < nodes.size(); ++i) {
                    for (Map.Entry<Character, Node> entry : nodes.get(i).children.entrySet()) {
                        tmpNodes.add(entry.getValue());
                        tmpPrefixs.add(prefixs.get(i) + entry.getKey());
                    }
                }
            } else {
                for (int i = 0; i < nodes.size(); ++i) {
                    Node child = nodes.get(i).getChild(c);
                    if (child != null) {
                        tmpNodes.add(child);
                        tmpPrefixs.add(prefixs.get(i) + c);
                    }
                }
            }
            nodes = tmpNodes;
            prefixs = tmpPrefixs;
        }

        List<String> rs = new ArrayList<>();
        for (int i = 0; i < nodes.size(); ++i) {
            getAll(prefixs.get(i), nodes.get(i), rs);
        }

        return rs;
    }

    @Override
    public void remove(String word) {
        remove(root, word);
    }

    private boolean remove(Node root, String word) {
        if (word.isEmpty()) {
            if (root.cnt > 0) {
                root.cnt--;
            }

            if (root.cnt == 0) {
                if (root.children.isEmpty()) {
                    return true;
                }
            }

            return false;
        }

        Node child = root.getChild(word.charAt(0));
        if (child == null) {
            return false;
        }

        boolean succ = remove(child, word.substring(1));
        if (!succ) {
            return false;
        }

        if (root.cnt == 0 && root.children.size() == 1) {
            root.children.clear();
            return true;
        }

        return false;
    }

    private void getAll(String prefix, Node root, List<String> rs) {
        if (root == null) {
            return;
        }
        if (root.cnt > 0) {
            rs.add(prefix);
        }
        Map<Character, Node> children = root.children;
        for (Map.Entry<Character, Node> node : children.entrySet()) {
            getAll(prefix + node.getKey(), node.getValue(), rs);
        }
    }

    public static void main(String[] args) {
        /*
        List<String> words = Arrays.asList("wenpengfei", "wpf", "wenpf", "wpfei", "pf");

        TrieTree trieTree = new TrieTree(words);
        List<String> result = trieTree.match(".");
        PrntUtils.printList(result);
        */
        TrieTree trieTree = new TrieTree();
        trieTree.add("wpf");
        trieTree.remove("wpf");

        trieTree.root.cnt++;
    }
}
