package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-stack-sequences
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/5/28
 */

public class VerifyStackSequence {


    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        Assert.assertTrue(validateStackSequences2(pushed, popped));
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> poppedStack = new Stack<>();

        for (int i = popped.length - 1; i >= 0; i--) {
            poppedStack.push(popped[i]);
        }
        int pushLeft = pushed.length;
        while ((pushStack.isEmpty() || !pushStack.peek().equals(poppedStack.peek())) && pushLeft > 0) {
            pushStack.push(pushed[pushed.length - --pushLeft - 1]);
        }

        while (!poppedStack.isEmpty()) {
            if (!pushStack.isEmpty() && pushStack.peek().equals(poppedStack.peek())) {
                pushStack.pop();
                poppedStack.pop();
            } else if (pushLeft-- > 0) {
                pushStack.push(pushed[pushed.length - pushLeft - 1]);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> pushedStack = new Stack<>();
        int popIndex = 0;
        for (int push : pushed) {
            pushedStack.push(push);
            while (!pushedStack.isEmpty() && popIndex < popped.length && popped[popIndex] == pushedStack.peek()) {
                pushedStack.pop();
                popIndex++;
            }
        }
        return popIndex == popped.length;
    }

}
