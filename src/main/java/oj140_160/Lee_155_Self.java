package oj140_160;

import java.util.Stack;

/**
 * 最小栈
 */
public class Lee_155_Self {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public Lee_155_Self() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            minStack.push(x >= minStack.peek() ? minStack.peek() : x);
        }
    }

    public void pop() {
        if (!stack.empty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
