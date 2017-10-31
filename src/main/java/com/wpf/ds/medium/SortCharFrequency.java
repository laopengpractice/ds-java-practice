package com.wpf.ds.medium;

import java.util.PriorityQueue;

/**
 * Created by wenpengfei on 2017/9/26.
 */
public class SortCharFrequency {

    static class CharFrequency implements Comparable<CharFrequency> {
        char c;
        int frequency;

        public CharFrequency(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        @Override public int compareTo(CharFrequency o) {
            return Integer.compare(o.frequency, frequency);
        }
    }

    public static String sortCharFrequency(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        PriorityQueue<CharFrequency> heap = new PriorityQueue<>();
        for (int i = 0; i < map.length; ++i) {
            if (map[i] == 0) {
                continue;
            }
            CharFrequency frequency = new CharFrequency((char) i, map[i]);
            heap.add(frequency);
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            CharFrequency frequency = heap.poll();
            for (int i = 0; i < frequency.frequency; ++i) {
                sb.append(frequency.c);
            }
        }

        return sb.toString();
    }

    static class Link<E> {
        E val;
        Link<E> next;
    }

    public static String sort2(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        Link<Character> cList = new Link<>();
        Link<Integer> iList = new Link<>();
        for (int i = 0; i < map.length; ++i) {
            if (map[i] == 0) {
                continue;
            }
            Link<Character> item = new Link<>();
            item.val = (char)i;
            Link<Integer> iItem = new Link<>();
            iItem.val = map[i];
            Link<Integer> ip = iList;
            Link<Character> cp = cList;
            while (ip.next != null && ip.next.val > iItem.val) {
                ip = ip.next;
                cp = cp.next;
            }
            iItem.next = ip.next;
            ip.next = iItem;
            item.next = cp.next;
            cp.next = item;
        }
        StringBuilder sb = new StringBuilder();
        while (cList.next != null) {
            for (int i = 0; i < iList.next.val; ++i) {
                sb.append(cList.next.val);
            }
            cList = cList.next;
            iList = iList.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sort2("wenpengfeiwenpengfeifeipengwen"));
    }
}
