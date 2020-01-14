package oj220_239;

import java.util.Stack;

/**
 * 栈实现队列
 */
public class Lee_232_Self {
    /** Initialize your data structure here. */
    private Stack<Integer> stack;
    private  Stack<Integer> queueStack;
    public Lee_232_Self() {
        stack = new Stack<>();
        queueStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (queueStack.empty()){
            while (!stack.empty()){
                int temp = stack.pop();
                queueStack.push(temp);
            }
        }
        return queueStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (queueStack.empty()){
            while (!stack.empty()){
                int temp = stack.pop();
                queueStack.push(temp);
            }
        }
        return queueStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack.empty() && queueStack.empty()){
            return true;
        }
        return false;
    }
}
