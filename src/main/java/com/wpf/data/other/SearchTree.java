package com.wpf.data.other;

import java.util.List;

/**
 * Created by wenpengfei on 2018/6/11.
 */
public interface SearchTree {

    void add(String word);

    List<String> search(String prefix);

    void remove(String word);

    List<String> match(String regex);
}
