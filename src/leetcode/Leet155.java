package leetcode;

import java.util.*;

public class Leet155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        int min = !minStack.isEmpty() ? minStack.peek() : x;
        minStack.add(x);
        minStack.add(x > min ? min : x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
