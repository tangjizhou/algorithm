package net.mshome.twisted.algorithm.practice;

import java.util.Stack;

/**
 * 逆序一个栈，仅用递归形式
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/15
 */
public class ReverseStack {

    public static void main(String[] args) {
        new ReverseStack().test();
    }

    private void test() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        reverse();
        for (Integer integer : stack) {
            System.out.print(integer + "\t");
        }
    }


    private Stack<Integer> stack;

    public ReverseStack() {
        this.stack = new Stack<>();
    }

    public void reverse() {
        if (this.stack.isEmpty()) {
            return;
        }
        Integer value = getAndRemoveLast();
        reverse();
        stack.push(value);
    }

    /**
     * 递归获取最下层的哪个元素
     *
     * @return 栈最深处的元素
     */
    public Integer getAndRemoveLast() {
        Integer value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        }

        Integer last = getAndRemoveLast();
        stack.push(value);
        return last;
    }


}
