package com.wpf.data.common;

/**
 * Created by wenpengfei on 2017/11/24.
 */
public class Vertical<T> {
    public T data;
    public Vertical<T> next;

    public Vertical(T data) {
        this.data = data;
    }
}
