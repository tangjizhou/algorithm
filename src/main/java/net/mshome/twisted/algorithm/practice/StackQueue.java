package net.mshome.twisted.algorithm.practice;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 两个栈组成的队列结构
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/14
 */
public class StackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(Integer value) {
        this.pushStack.push(value);
    }

    public Integer poll() {
        transfer();
        if (this.popStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.popStack.pop();
    }

    public Integer peek() {
        transfer();
        if (this.popStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.popStack.peek();
    }

    private void transfer() {
        if (this.pushStack.isEmpty() || !this.popStack.isEmpty()) {
            return;
        }

        while (!this.pushStack.isEmpty()) {
            this.popStack.push(this.pushStack.pop());
        }
    }

}
