package com.wpf.data;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by wenpengfei on 2017/9/5.
 */
public class StackUseQueue<T> {

    private Queue<T>[] queues;
    private int curIndex;

    public StackUseQueue() {
        queues = new Queue[2];
        queues[0] = new ArrayDeque<>();
        queues[1] = new ArrayDeque<>();
        curIndex = 0;
    }

    public T pop() {
        return queues[curIndex].poll();
    }

    public T top() {
        return queues[curIndex].peek();
    }

    public void push(T item) {
        Queue<T> emptyQueue = queues[curIndex ^ 1];
        Queue<T> useQueue = queues[curIndex];

        emptyQueue.add(item);
        while (!useQueue.isEmpty()) {
            emptyQueue.add(useQueue.poll());
        }

        curIndex ^= 1;
    }

    public boolean empty() {
        return queues[0].isEmpty() && queues[1].isEmpty();
    }
}
