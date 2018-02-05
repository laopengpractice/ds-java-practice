package com.wpf.data.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wenpengfei on 2017/9/18.
 */
public class TinyUrl {

    private Map<String, String> tinyMap;
    private Map<String, String> originMap;

    private Random random;

    public TinyUrl() {
        tinyMap = new HashMap<>();
        originMap = new HashMap<>();

        random = new Random();
    }

    public String encode(String url) {
        if (originMap.containsKey(url)) {
            return originMap.get(url);
        }

        String newTiny;
        while (true) {
            newTiny = randomUrl();
            if (tinyMap.containsKey(newTiny)) {
                System.out.println("collision");
                continue;
            }
            originMap.put(url, newTiny);
            tinyMap.put(newTiny, url);
            break;
        }

        return newTiny;
    }

    public String decode(String url) {
        return tinyMap.get(url);
    }

    private String randomUrl() {
        int len;
        while ((len = random.nextInt(20)) < 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            int type = random.nextInt(3);
            char c = 'z';
            switch (type) {
                case 0:
                    c = (char) ('0' + random.nextInt(10));
                    break;
                case 1:
                    c = (char)('a' + random.nextInt(26));
                    break;
                case 2:
                    c = (char)('A' + random.nextInt(26));
                    break;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TinyUrl url = new TinyUrl();
        System.out.println(url.encode("https://www.baidu.com"));
        System.out.println(url.encode("https://www.google.com"));
        System.out.println(url.encode("https://www.tigerbrokers.com"));
        System.out.println(url.encode("https://www.tigerbrokers.com/stock"));
        System.out.println(url.encode("https://www.google.com"));
    }
}
