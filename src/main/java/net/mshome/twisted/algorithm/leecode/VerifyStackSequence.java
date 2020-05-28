package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
