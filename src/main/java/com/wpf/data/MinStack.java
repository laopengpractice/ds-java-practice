package com.wpf.data;

import java.util.Stack;

/** * Created by wenpengfei on 2017/9/11.
 */
public class MinStack {

    Stack<Integer> cur;;
    Stack<Integer> min;

    public MinStack() {
        cur = new Stack<>();
        min = new Stack<>();
    }

    public void push(int n) {
        cur.push(n);
        if (!min.isEmpty()) {
            if (min.peek() >= n) {
               min.push(n);
            }
        } else {
            min.push(n);
        }
    }

    public int top() {
        return cur.peek();
    }

    public int pop() {
        int n = cur.pop();
        if (n == min.peek()) {
            min.pop();
        }

        return n;
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.push(1);;
        stack.push(-3);
        stack.push(-1);
        stack.push(-3);

        System.out.println(stack.min());stack.pop();stack.pop();
        System.out.println(stack.min());
        stack.pop();stack.pop();stack.pop();stack.pop();
        System.out.println(stack.min());
    }
}
