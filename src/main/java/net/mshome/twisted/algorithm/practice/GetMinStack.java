package net.mshome.twisted.algorithm.practice;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 设计一个可以获取最小值的栈，利用现有栈结构
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/14
 */
public class GetMinStack {

    // 第一种方式
    class GetMinStack1 {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public GetMinStack1() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(Integer value) {
            stack.push(value);
            if (minStack.isEmpty() || value <= minStack.peek()) {
                minStack.push(value);
            }
        }

        public Integer pop() {
            if (stack.isEmpty()) {
                throw new EmptyStackException();
            }
            Integer value = stack.pop();
            if (value.equals(minStack.peek())) {
                minStack.pop();
            }
            return value;

        }

        public Integer getMin() {
            if (minStack.isEmpty()) {
                throw new EmptyStackException();
            }
            return minStack.peek();
        }

    }

    // 第二种
    class GetMinStack2 {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public GetMinStack2() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(Integer value) {
            stack.push(value);
            if (minStack.isEmpty()) {
                minStack.push(value);
            }
            if (value >= minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(value);
            }
        }

        public Integer pop() {
            if (stack.isEmpty()) {
                throw new EmptyStackException();
            }
            minStack.pop();
            return stack.pop();

        }

        public Integer getMin() {
            if (minStack.isEmpty()) {
                throw new EmptyStackException();
            }
            return minStack.peek();
        }

    }

}
