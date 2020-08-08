package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 栈实现队列
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/8/8
 */
class MyQueue {

    private final Stack<Integer> pushStack;
    private final Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}

class MyQueue2 {

    private final Stack<Integer> pushStack;

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.push(1);
        myQueue2.push(2);
        myQueue2.push(3);
        myQueue2.push(4);
        myQueue2.push(5);
        System.out.println(myQueue2.peek());
        while (!myQueue2.empty()) {
            System.out.println(myQueue2.pop());
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        pushStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int ret = 0;
        int value = pushStack.pop();
        if (pushStack.isEmpty()) {
            return value;
        }
        ret = pop();
        pushStack.push(value);
        return ret;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int ret = 0;
        int value = pushStack.pop();
        if (pushStack.isEmpty()) {
            ret = value;
        } else {
            ret = peek();
        }
        pushStack.push(value);
        return ret;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty();
    }


}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */