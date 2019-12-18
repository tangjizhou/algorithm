package net.mshome.twisted.algorithm.util;

import java.util.Stack;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/18
 */
public class StackUtils {


    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }

    }

}
