package net.mshome.twisted.algorithm.practice;

import net.mshome.twisted.algorithm.util.StackUtils;

import java.util.Stack;

/**
 * 栈排序
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/18
 */
public class SortStack extends Stack<Integer> {


    public static void main(String[] args) {
        new SortStack().test();
    }

    private void test() {
        this.push(3);
        this.push(5);
        this.push(1);
        this.push(2);
        this.push(4);
        sort();

        StackUtils.printStack(this);

    }


    private Stack<Integer> helper;

    public SortStack() {
        this.helper = new Stack<>();
    }

    public void sort() {

        while (!this.isEmpty()) {
            int value = this.pop();

            while (!helper.isEmpty() && value > helper.peek()) {
                this.push(helper.pop());
            }
            helper.push(value);
        }
        while (!helper.isEmpty()) {
            this.push(helper.pop());
        }
    }


}
